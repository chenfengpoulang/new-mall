package com.mall.service.impl;

import com.mall.config.OrderConfigure;
import com.mall.service.MessageService;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Override
    public void sendOrderInfo(String msgContent) {
        this.rabbitTemplate.setReturnCallback(this);
        this.rabbitTemplate.setConfirmCallback((correlationData, ack, cause) -> {
            if (!ack) {
                //数据库保存消息发送状态
                //todo
                System.out.println("sendOrderInfo消息发送失败" + cause + correlationData.toString());
            } else {
                //数据库保存消息发送状态
                //todo
                System.out.println("sendOrderInfo 消息发送成功 ");
            }
        });
        this.rabbitTemplate.convertAndSend(OrderConfigure.SPRING_BOOT_BIND_KEY, msgContent);
    }

    @Override
    public void returnedMessage(Message message, int i, String s, String s1, String s2) {

    }
}
