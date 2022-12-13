package com.jcohy.sample.spring_cloud.provider.student.service.impl;

import com.codingapi.txlcn.tc.annotation.LcnTransaction;
import com.jcohy.sample.spring_cloud.provider.CourseDto;
import com.jcohy.sample.spring_cloud.provider.TeacherDto;
import com.jcohy.sample.spring_cloud.provider.student.dto.StudentScore;
import com.jcohy.sample.spring_cloud.provider.student.repository.ScRepository;
import com.jcohy.sample.spring_cloud.provider.student.repository.StudentRepository;
import com.jcohy.sample.spring_cloud.provider.student.service.StudentService;
import com.jcohy.sample.spring_cloud.provider.student.service.TeacherFignApi;
import com.jcohy.sample.spring_cloud.provider.student.model.Sc;
import com.jcohy.sample.spring_cloud.provider.student.model.Student;
import com.jcohy.sample.spring_cloud.provider.student.service.CoureFignApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository studentRepository;

	@Autowired
	private CoureFignApi coureFignApi;

	@Autowired
	private TeacherFignApi teacherFignApi;

	@Autowired
	private ScRepository scRepository;

	@Override
	public Student add(Student student) {
		return studentRepository.save(student);
	}

	@Override
	public Student get(Long id) {
		return studentRepository.getOne(id);
	}

	@Override
	public List<Student> list() {
		return studentRepository.findAll();
	}

	@Override
	public StudentScore getStudentScoreByName(String name) {
		return getStudentScore(studentRepository.findStudentBySname(name).get().getSid());
	}

	@Override
	public StudentScore getStudentScore(Long id) {

		StudentScore studentSocre = new StudentScore();

		List<Sc> scs = scRepository.findScoreById(id);
		Student student = get(id);
		studentSocre.setSname(student.getSname());

		List<Map<String, Object>> mapList = new ArrayList<>();
		for (Sc sc : scs) {
			Map<String, Object> map = new HashMap<>();
			Long cid = sc.getCid();
			Integer score = sc.getScore();
			CourseDto courseDto = coureFignApi.get(cid);
			Long tid = courseDto.getTid();
			TeacherDto teacherDto = teacherFignApi.get(tid);
			map.put("cname", courseDto.getCname());
			map.put("tname", teacherDto.getTname());
			map.put("score", score);
			mapList.add(map);
		}
		studentSocre.setMapList(mapList);
		return studentSocre;
	}

	@Override
	@LcnTransaction
	@Transactional
	public String addStudentScore(StudentScore studentScore, String exFlag) {
		String sname = studentScore.getSname();

		List<Map<String, Object>> mapList = studentScore.getMapList();

		Student student = studentRepository.save(studentRepository.findStudentBySname(sname).orElse(new Student(sname, "55", "男")));

		// Thread.sleep(1000);
		for (Map<String, Object> map : mapList) {
			String cname = (String) map.get("cname");
			String tname = (String) map.get("tname");
			Integer score = (Integer) map.get("score");
			// int s = 4/0;
			TeacherDto teacherDto = new TeacherDto();
			teacherDto.setTname(tname);
			TeacherDto tDto = teacherFignApi.add(teacherDto);

			CourseDto courseDto = new CourseDto();
			courseDto.setCname(cname);

			courseDto.setTid(tDto.getTid());
			CourseDto cDto = coureFignApi.add(courseDto);

			Sc sc = new Sc(student.getSid(), cDto.getCid(), score);
			scRepository.save(sc);

			// 置异常标志，DTX 回滚
			if (Objects.nonNull(exFlag)) {
				throw new IllegalStateException("by exFlag");
			}
		}
		return "Successful";
	}

}
