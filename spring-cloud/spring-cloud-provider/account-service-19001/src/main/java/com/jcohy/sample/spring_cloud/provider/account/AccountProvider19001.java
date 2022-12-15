package com.jcohy.sample.spring_cloud.provider.account;

import com.jcohy.sample.spring_cloud.provider.account.entity.Account;
import com.jcohy.sample.spring_cloud.provider.account.repository.AccountRepository;
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
public class AccountProvider19001 {

	public static void main(String[] args) {
		SpringApplication.run(AccountProvider19001.class, args);
	}

	@Bean
	public CommandLineRunner demo(AccountRepository repository) {
		return args -> {
			repository.save(new Account(1L, "1001", new BigDecimal(10000)));
			repository.save(new Account(2L, "1002", new BigDecimal(10000)));
		};
	}

}
