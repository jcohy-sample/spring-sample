package com.jcohy.sample.spring_cloud.provider.student.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Copyright: Copyright (c) 2019 https://www.jcohy.com
 *
 * @author jcohy
 */

@Configuration
public class FeignServiceConfig {

	@Bean
	Logger.Level feignLoggerLevel() {
		return Logger.Level.FULL;
	}

}
