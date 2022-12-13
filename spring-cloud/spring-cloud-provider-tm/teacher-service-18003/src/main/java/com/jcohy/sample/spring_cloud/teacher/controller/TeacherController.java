package com.jcohy.sample.spring_cloud.teacher.controller;

import com.jcohy.sample.spring_cloud.provider.TeacherDto;
import com.jcohy.sample.spring_cloud.teacher.model.Teacher;
import com.jcohy.sample.spring_cloud.teacher.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TeacherController {

	@Autowired
	private TeacherService service;

	@Autowired
	private DiscoveryClient client;

	@RequestMapping(value = "/teacher/add", method = RequestMethod.POST)
	public com.jcohy.sample.spring_cloud.provider.TeacherDto add(@RequestBody TeacherDto teacherDto) {
		return service.add(new Teacher(teacherDto.getTname()));
	}

	@RequestMapping(value = "/teacher/get/{id}", method = RequestMethod.GET)
	public TeacherDto get(@PathVariable("id") Long id) {
		return service.get(id);
	}

	@RequestMapping(value = "/teacher/list", method = RequestMethod.GET)
	public List<TeacherDto> list() {
		return service.list();
	}

	@RequestMapping(value = "/teacher/{name}", method = RequestMethod.GET)
	public TeacherDto getTeacherByName(@PathVariable("name") String name) {
		return service.getByName(name);
	}

	@RequestMapping(value = "/teacher/discovery", method = RequestMethod.GET)
	public Object discovery() {
		List<String> list = client.getServices();
		System.out.println("**********" + list);

		List<ServiceInstance> srvList = client.getInstances("provider-teacher");
		for (ServiceInstance element : srvList) {
			System.out.println(element.getServiceId() + "\t" + element.getHost() + "\t" + element.getPort() + "\t"
					+ element.getUri());
		}
		return this.client;
	}

}
