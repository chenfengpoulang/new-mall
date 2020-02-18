package com.mall.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OrderRabbtBeanConfig {
    @Bean
    public Queue QueueOrder() {
        return new Queue(OrderConfigure.SPRING_BOOT_QUEUE);
    }

    /**
     * Fanout 就是我们熟悉的广播模式或者订阅模式，给Fanout交换机发送消息，绑定了这个交换机的所有队列都收到这个消息。
     * @return
     */
    @Bean
    FanoutExchange fanoutExchange() {
        return new FanoutExchange(OrderConfigure.SPRING_BOOT_EXCHANGE);
    }


    @Bean
    Binding bindingExchangeA(Queue QueueOrder, FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(QueueOrder).to(fanoutExchange);
    }




}
