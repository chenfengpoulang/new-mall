package com.mall.service;

import com.mall.entity.UserInfo;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserServiceImpl {

    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "userFallback")
    public UserInfo findUserById(long id){
        String url = "http://MALL-USER/userOutinfo/findUserById?id=" + id;
        UserInfo userInfo =  restTemplate.getForObject(url,UserInfo.class);
        return userInfo;
    }

    /**
     * 熔断方法，生产上可调用备用服务
     * @param id
     * @return
     */
    public UserInfo userFallback(long id){
        UserInfo userInfo = new UserInfo();
        userInfo.setId(1000l);
        return userInfo;
    }
}
