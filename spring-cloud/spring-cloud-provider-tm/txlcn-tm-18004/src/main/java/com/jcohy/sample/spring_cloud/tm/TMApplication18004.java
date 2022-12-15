package com.jcohy.sample.spring_cloud.tm;

import com.codingapi.txlcn.tm.config.EnableTransactionManagerServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableTransactionManagerServer
public class TMApplication18004 {

	public static void main(String[] args) {
		SpringApplication.run(TMApplication18004.class, args);
	}

}
