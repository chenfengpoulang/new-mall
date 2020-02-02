package com.mall.service;

import com.mall.entity.UserInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@FeignClient(value = "mall-user")
public interface UserService {

    @RequestMapping(value = "userOutinfo/insertUser")
    public void insertUser(@RequestBody UserInfo userInfo);

    @RequestMapping(value = "userOutinfo/findUserById")
    public UserInfo findUserById(@RequestParam(value = "id") long id);

    @RequestMapping(value = "userOutinfo/updateUserById")
    public void updateUserById(@RequestBody UserInfo userinfo);

    @RequestMapping(value = "userOutinfo/login")
    public Map<String,String> login(@RequestParam(value = "account") String account, @RequestParam(value = "passw") String passw);
}
