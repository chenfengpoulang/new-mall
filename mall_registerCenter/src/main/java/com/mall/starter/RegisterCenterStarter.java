package com.mall.starter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class RegisterCenterStarter {
    public static void main(String[] args) {
        SpringApplication.run(RegisterCenterStarter.class, args);
    }
}
