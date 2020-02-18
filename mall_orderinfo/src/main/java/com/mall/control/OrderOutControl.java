package com.mall.control;

import com.mall.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "orderout")
public class OrderOutControl {

    @Autowired
    private MessageService messageService;

    @RequestMapping(value = "sendOrderMessage",method = RequestMethod.POST)
    public void sendOrderMessage(String msgContent) {
        messageService.sendOrderInfo(msgContent);
    }
}
