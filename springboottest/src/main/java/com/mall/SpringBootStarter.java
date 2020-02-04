package com.mall;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootStarter {
    public static void main(String[] args) {
        SpringApplication.run(UserStarter.class,args);
    }
}
