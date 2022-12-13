package com.jcohy.sample.spring_cloud.provider.course;


import com.codingapi.txlcn.tc.config.EnableDistributedTransaction;
import com.jcohy.sample.spring_cloud.provider.course.model.Course;
import com.jcohy.sample.spring_cloud.provider.course.repository.CourseRepository;
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
public class CourseProvider18001 {

    private static final Logger log = LoggerFactory.getLogger(CourseProvider18001.class);

    public static void main(String[] args) {
        SpringApplication.run(CourseProvider18001.class, args);
    }

//    @Bean
//    public CommandLineRunner demo(CourseRepository repository) {
//        return args -> {
//            repository.save(new Course("语文",2L));
//            repository.save(new Course("数学",1L));
//            repository.save(new Course("英语",3L));
//            repository.save(new Course("语文",4L));
//            repository.save(new Course("数学",5L));
//            repository.save(new Course("语文",6L));
//            repository.save(new Course("数学",7L));
//
//            log.info("Course found with findAll():");
//            log.info("-------------------------------");
//            for (Course customer : repository.findAll()) {
//                log.info(customer.toString());
//            }
//        };
//    }
}
