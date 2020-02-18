package com.mall.service;

import org.springframework.amqp.rabbit.core.RabbitTemplate;

public interface MessageService  extends  RabbitTemplate.ReturnCallback
{

    /**
     * 发送消息
     *
     * @param msgContent
     */
    public void sendOrderInfo(String msgContent);
}
