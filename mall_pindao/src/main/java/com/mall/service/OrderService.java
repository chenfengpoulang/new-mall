package com.mall.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "mall_orderinfo")
public interface OrderService {
    @RequestMapping(value = "orderout/sendOrderMessage",method = RequestMethod.POST)
    public void sendOrderMessage(@RequestParam(value = "msgContent") String msgContent);
}
