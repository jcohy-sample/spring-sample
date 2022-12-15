package com.jcohy.sample.spring_cloud.teacher;

import com.codingapi.txlcn.tc.config.EnableDistributedTransaction;
import com.jcohy.sample.spring_cloud.teacher.model.Teacher;
import com.jcohy.sample.spring_cloud.teacher.repository.TeacherRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableEurekaClient // 本服务启动后会自动注册进eureka服务中
@EnableDiscoveryClient // 服务发现
@EnableDistributedTransaction
public class TeacherProvider18003 {

	private static final Logger log = LoggerFactory.getLogger(TeacherProvider18003.class);

	public static void main(String[] args) {
		SpringApplication.run(TeacherProvider18003.class, args);
	}

	@Bean
	public CommandLineRunner demo(TeacherRepository repository) {
		return args -> {
			repository.save(new Teacher("张三"));
			repository.save(new Teacher("李四"));
			repository.save(new Teacher("王五"));

			log.info("Course found with findAll():");
			log.info("-------------------------------");
			for (Teacher teacher : repository.findAll()) {
				log.info(teacher.toString());
			}
		};
	}

}
