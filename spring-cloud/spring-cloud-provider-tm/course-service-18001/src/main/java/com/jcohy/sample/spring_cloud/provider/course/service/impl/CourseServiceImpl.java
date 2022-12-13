package com.jcohy.sample.spring_cloud.provider.course.service.impl;

import com.codingapi.txlcn.tc.annotation.DTXPropagation;
import com.codingapi.txlcn.tc.annotation.LcnTransaction;
import com.jcohy.sample.spring_cloud.provider.course.model.Course;
import com.jcohy.sample.spring_cloud.provider.course.repository.CourseRepository;
import com.jcohy.sample.spring_cloud.provider.course.service.CourseService;
import com.jcohy.sample.spring_cloud.provider.CourseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseServiceImpl implements CourseService {

	@Autowired
	private CourseRepository courseRepository;

	@Autowired
	private PlatformTransactionManager platformTransactionManager;

	// tag::code[]
	@Override
	@LcnTransaction(propagation = DTXPropagation.SUPPORTS)
	@Transactional
	public CourseDto add(Course course) {
		return Course.ofDto(courseRepository.save(course));
	}
	// end::code[]

	@Override
	public CourseDto get(Long id) {
		return Course.ofDto(courseRepository.getOne(id));
	}

	@Override
	public List<CourseDto> list() {
		return courseRepository.findAll().stream().map(Course::ofDto).collect(Collectors.toList());
	}

	@Override
	public CourseDto getByByName(String name) {
		return Course.ofDto(courseRepository.getByCname(name));
	}

}
