package com.jcohy.sample.spring_cloud.teacher.service;


import com.jcohy.sample.spring_cloud.provider.TeacherDto;
import com.jcohy.sample.spring_cloud.teacher.model.Teacher;

import java.util.List;

public interface TeacherService {

	public TeacherDto add(Teacher teacher);

	public TeacherDto get(Long id);

	public List<TeacherDto> list();

	public TeacherDto getByName(String name);

}
