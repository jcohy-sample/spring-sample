package com.jcohy.sample.spring_cloud.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 描述: .
 * <p>
 * Copyright © 2022
 * <a href="https://www.jcohy.com" target= "_blank">https://www.jcohy.com</a>
 * </p>
 *
 * @author jiac
 * @version 2022.04.0 2022/9/9:15:20
 * @since 2022.04.0
 */
@SpringBootApplication
@EnableDiscoveryClient
public class GatewaySampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewaySampleApplication.class, args);
	}

}
