package com.jcohy.sample.spring_cloud.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * 描述: .
 * <p>
 * Copyright © 2022
 * <a href="https://www.jcohy.com" target= "_blank">https://www.jcohy.com</a>
 * </p>
 *
 * @author jiac
 * @version 2022.04.0 2022/9/9:14:20
 * @since 2022.04.0
 */
@EnableEurekaServer
@SpringBootApplication
public class EurekaSampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaSampleApplication.class, args);
	}

}
