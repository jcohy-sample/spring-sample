package com.jcohy.sample.spring_cloud.teacher.service.impl;

import com.codingapi.txlcn.tc.annotation.DTXPropagation;
import com.codingapi.txlcn.tc.annotation.LcnTransaction;
import com.jcohy.sample.spring_cloud.provider.TeacherDto;
import com.jcohy.sample.spring_cloud.teacher.model.Teacher;
import com.jcohy.sample.spring_cloud.teacher.repository.TeacherRepository;
import com.jcohy.sample.spring_cloud.teacher.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TeacherServiceImpl implements TeacherService {

	@Autowired
	private TeacherRepository teacherRepository;

	@Override
	@LcnTransaction(propagation = DTXPropagation.SUPPORTS)
	@Transactional
	public TeacherDto add(Teacher teacher) {
		return Teacher.ofDto(teacherRepository.save(teacher));
	}

	@Override
	public TeacherDto get(Long id) {
		Teacher one = teacherRepository.getOne(id);
		return Teacher.ofDto(one);
	}

	@Override
	public List<TeacherDto> list() {
		List<Teacher> teachers = teacherRepository.findAll();
		return teachers.stream().map(Teacher::ofDto).collect(Collectors.toList());
	}

	@Override
	public TeacherDto getByName(String name) {
		return Teacher.ofDto(teacherRepository.getByTname(name));
	}

}
