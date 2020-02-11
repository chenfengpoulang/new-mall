package com.mall.config;

import org.springframework.context.annotation.Configuration;

@Configuration
public class OrderConfigure {

    // 队列名称
    public final static String SPRING_BOOT_QUEUE = "order-queue";
    // 交换机名称
    public final static String SPRING_BOOT_EXCHANGE = "order-exchange";
    // 绑定的值
    public static final String SPRING_BOOT_BIND_KEY = "order-key";
}


