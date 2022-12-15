package com.jcohy.sample.spring_cloud.provider.student.controller;

import com.jcohy.sample.spring_cloud.provider.student.service.FeignAPi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Copyright: Copyright (c) 2019 https://www.jcohy.com
 *
 * @author jcohy
 */

@RestController
public class FeignController {

	@Autowired
	private FeignAPi helloFeignService;

	// 服务消费者对位提供的服务
	@GetMapping(value = "/search/github")
	public String searchGithubRepoByStr(@RequestParam("str") String queryStr) {
		return helloFeignService.searchRepo(queryStr);
	}

}
