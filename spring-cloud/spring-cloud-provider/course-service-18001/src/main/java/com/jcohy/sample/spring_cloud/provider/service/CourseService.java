package com.jcohy.sample.spring_cloud.provider.service;


import com.jcohy.sample.spring_cloud.provider.CourseDto;
import com.jcohy.sample.spring_cloud.provider.model.Course;

import java.util.List;

public interface CourseService {

	public CourseDto add(Course course);

	public CourseDto get(Long id);

	public List<CourseDto> list();

	public CourseDto getByByName(String name);

}
