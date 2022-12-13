package com.jcohy.sample.spring_cloud.provider.student;

import com.jcohy.sample.spring_cloud.provider.student.repository.ScRepository;
import com.jcohy.sample.spring_cloud.provider.student.repository.StudentRepository;
import com.jcohy.sample.spring_cloud.provider.student.model.Sc;
import com.jcohy.sample.spring_cloud.provider.student.model.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableEurekaClient // 本服务启动后会自动注册进eureka服务中
@EnableDiscoveryClient // 服务发现
@EnableFeignClients
public class StudentProvider18002 {

    private static final Logger log = LoggerFactory.getLogger(StudentProvider18002.class);

    public static void main(String[] args) {
        SpringApplication.run(StudentProvider18002.class, args);
    }


    @Bean
    public CommandLineRunner demo(StudentRepository repository, ScRepository scRepository) {
        return args -> {
            repository.save(new Student("赵雷", "19900101", "男"));
            repository.save(new Student("田电", "19901221", "男"));
            repository.save(new Student("孙风", "19900520", "男"));
            repository.save(new Student("李云", "19900806", "男"));
            repository.save(new Student("周梅", "19911201", "女"));
            repository.save(new Student("吴兰", "19920301", "女"));
            repository.save(new Student("郑竹", "19890701", "女"));
            repository.save(new Student("王菊", "19900120", "女"));

            log.info("Course found with findAll():");
            log.info("-------------------------------");
            for (Student student : repository.findAll()) {
                log.info(student.toString());
            }
        };
    }
}
