package com.jcohy.sample.spring_cloud.provider.student.service;

import com.jcohy.sample.spring_cloud.provider.student.dto.StudentScore;
import com.jcohy.sample.spring_cloud.provider.student.model.Student;

import java.util.List;

public interface StudentService {

	public Student add(Student student);

	public Student get(Long id);

	public List<Student> list();

	public StudentScore getStudentScore(Long id);

	public StudentScore getStudentScoreByName(String name);

	public String addStudentScore(StudentScore studentSocre, String exFlag);

}
