package com.jcohy.sample.spring_cloud.provider.student.service;

import com.jcohy.sample.spring_cloud.provider.student.config.FeignServiceConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Copyright: Copyright (c) 2019 https://www.jcohy.com
 *
 * @author jcohy
 */

@FeignClient(name = "github-client", url = "https://api.github.com", configuration = FeignServiceConfig.class)
public interface FeignAPi {

	@RequestMapping(value = "/search/repositories", method = RequestMethod.GET)
	String searchRepo(@RequestParam("q") String queryStr);

}
