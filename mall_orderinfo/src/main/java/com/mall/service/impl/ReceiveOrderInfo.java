package com.mall.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.mall.config.OrderConfigure;
import com.mall.entity.OrderTotal;
import com.mall.entity.Orderdetail;
import com.mall.entity.Ordermain;
import com.mall.service.OrderService;
import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
@RabbitListener(queues = OrderConfigure.SPRING_BOOT_QUEUE)
public class ReceiveOrderInfo {

    @Autowired
    private OrderService orderService;

    @RabbitHandler
    public void receive_2(String content, Channel channel, Message message) {
        System.out.println("[ReceiveOrderInfo] receive msg: " + content);
        try {
            OrderTotal orderTotal = JSONObject.parseObject(content,OrderTotal.class);
            Orderdetail orderdetail = orderTotal.getOrderdetail();
            Ordermain ordermain = orderTotal.getOrdermain();
            boolean isProcess = isProcess(ordermain);//幂等，防止重复插入
            if(!isProcess) {
                List<Orderdetail> detailList = new ArrayList<Orderdetail>();
                detailList.add(orderdetail);
                orderService.insertOrder(ordermain, detailList);
                System.out.println("receiver success");
            }
            //告诉服务器收到这条消息 已经被我消费了 可以在队列删掉 这样以后就不会再发了 否则消息服务器以为这条消息没处理掉 后续还会在发
            channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
        } catch (Exception e) {
            e.printStackTrace();
            //丢弃这条消息
            try {
                channel.basicNack(message.getMessageProperties().getDeliveryTag(), false,false);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            System.out.println("receiver fail");
        }
    }

    private boolean isProcess(Ordermain ordermain) {
        String tradenumber = ordermain.getTradenumber();
        Ordermain ordermain1 = orderService.findOrderInofByTradenumber(tradenumber);
        return ordermain1 != null?true:false;
    }

}
