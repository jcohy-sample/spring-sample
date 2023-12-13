package com.jcohy.sample.spring.framework.demo.controller;

import com.jcohy.sample.spring.framework.demo.service.DemoService;
import com.jcohy.sample.spring.framework.mvcframework.annotation.JcohyAutowired;
import com.jcohy.sample.spring.framework.mvcframework.annotation.JcohyController;
import com.jcohy.sample.spring.framework.mvcframework.annotation.JcohyRequestMapping;
import com.jcohy.sample.spring.framework.mvcframework.annotation.JcohyRequestParam;

import java.io.IOException;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Created by jiac on 2019/3/21. ClassName : com.jcohy.study.mvc.demo.controller
 * Description :
 */
@JcohyController
public class DemoController {

	@JcohyAutowired
	private DemoService demoService;

	@JcohyRequestMapping("/hello")
	public void hello(HttpServletRequest request, HttpServletResponse response, @JcohyRequestParam("name") String name)
			throws IOException {
		String result = demoService.show(name);
		response.getWriter().write(result);
	}

}
