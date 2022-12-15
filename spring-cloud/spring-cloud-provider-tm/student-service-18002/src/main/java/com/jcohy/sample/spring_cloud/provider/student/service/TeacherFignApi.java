package com.jcohy.sample.spring_cloud.provider.student.service;

import com.jcohy.sample.spring_cloud.provider.TeacherDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Copyright: Copyright (c) 2019 https://www.jcohy.com
 *
 * @author jcohy
 */

@FeignClient(value = "PROVIDER-TEACHER")
public interface TeacherFignApi {

	@RequestMapping(value = "/teacher/add", method = RequestMethod.POST)
	public TeacherDto add(@RequestBody TeacherDto teacherDto);

	@RequestMapping(value = "/teacher/get/{id}", method = RequestMethod.GET)
	public TeacherDto get(@PathVariable("id") Long id);

	@RequestMapping(value = "/teacher/list", method = RequestMethod.GET)
	public List<TeacherDto> list();

	@RequestMapping(value = "/teacher/{name}", method = RequestMethod.GET)
	public TeacherDto getTeacherByName(@PathVariable("name") String name);

}
