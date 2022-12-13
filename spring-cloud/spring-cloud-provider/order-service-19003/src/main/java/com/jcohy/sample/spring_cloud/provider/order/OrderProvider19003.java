package com.jcohy.sample.spring_cloud.provider.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class OrderProvider19003 {

    public static void main(String[] args) {
        SpringApplication.run(OrderProvider19003.class, args);
    }
}
