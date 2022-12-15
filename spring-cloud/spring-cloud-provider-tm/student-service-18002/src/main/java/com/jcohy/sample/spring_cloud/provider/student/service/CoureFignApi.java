package com.jcohy.sample.spring_cloud.provider.student.service;

import com.jcohy.sample.spring_cloud.provider.CourseDto;
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

@FeignClient(value = "PROVIDER-COURSE")
public interface CoureFignApi {

	@RequestMapping(value = "/course/get/{id}", method = RequestMethod.GET)
	public CourseDto get(@PathVariable("id") long id);

	@RequestMapping(value = "/course/list", method = RequestMethod.GET)
	public List<CourseDto> list();

	@RequestMapping(value = "/course/add", method = RequestMethod.POST)
	public CourseDto add(@RequestBody CourseDto courseDto);

	@RequestMapping(value = "/course/{name}", method = RequestMethod.GET)
	public CourseDto getCourse(@PathVariable("name") String name);

}
