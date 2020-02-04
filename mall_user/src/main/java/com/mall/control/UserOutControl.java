package com.mall.control;

import com.alibaba.fastjson.JSONObject;
import com.mall.entity.ProductTotal;
import com.mall.entity.UserInfo;
import com.mall.service.RedisService;
import com.mall.service.UserService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping(value = "userOutinfo")
public class UserOutControl {

    @Autowired
    private UserService userService;
    @Autowired
    private RedisService redisService;

    @RequestMapping(value = "toInsertUser")
    public String toInsertUser(){
        return "insertUser";
    }


    @RequestMapping(value = "insertUser")
    public void insertUser(@RequestBody  UserInfo userInfo){
        userService.insertUserInfo(userInfo);
    }

    @RequestMapping(value = "findUserById")
    public UserInfo findUserById(@RequestParam  long id){
        UserInfo userInfo = userService.findUserById(id);
        return userInfo;
    }

    @RequestMapping(value = "updateUserById")
    public void updateUserById(@RequestBody UserInfo userinfo) {
        UserInfo userInfo = userService.updateUserById(userinfo);
        String userinfoString = redisService.getStr("userinfo:"+userInfo.getId());
        if(StringUtils.isNotBlank(userinfoString)){
            String userinfoJson = JSONObject.toJSONString(userInfo);
            redisService.setStr("userinfo:"+userInfo.getId(),userinfoJson);
        }
    }

    @RequestMapping(value = "toLogin")
    public String toLogin() {
        return "toLoginUser";
    }

    @RequestMapping(value = "login")
    public Map<String,String> login(@RequestParam  String account,@RequestParam  String passw) {
        Map<String,String> resultMap = userService.validLogin(account,passw);
        return resultMap;
    }


}
