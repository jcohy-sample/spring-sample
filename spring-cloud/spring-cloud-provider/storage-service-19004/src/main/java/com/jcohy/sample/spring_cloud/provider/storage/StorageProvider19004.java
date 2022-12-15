package com.jcohy.sample.spring_cloud.provider.storage;

import com.jcohy.sample.spring_cloud.provider.storage.entity.Storage;
import com.jcohy.sample.spring_cloud.provider.storage.repository.StorageRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class StorageProvider19004 {

	public static void main(String[] args) {
		SpringApplication.run(StorageProvider19004.class, args);
	}

	@Bean
	public CommandLineRunner demo(StorageRepository repository) {
		return args -> {
			repository.save(new Storage(1L, "2001", 10000));
		};
	}

}
