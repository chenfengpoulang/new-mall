package com.mall.control;

import com.alibaba.fastjson.JSONObject;
import com.mall.entity.ProductTotal;
import com.mall.entity.UserInfo;
import com.mall.service.RedisService;
import com.mall.service.UserService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

@Controller
@RequestMapping(value = "userControl")
public class UserControl {

    @Autowired
    private UserService userService;
    @Autowired
    private RedisService redisService;

    @RequestMapping(value = "toInsertUser")
    public String toInsertUser(){
        return "beautiful/register";
    }


    @RequestMapping(value = "insertUser",method = RequestMethod.POST)
    public void insertUser(UserInfo userInfo){
        userService.insertUser(userInfo);
    }

    @RequestMapping(value = "findUserById")
    public String findUserById(long id,Model model){
        //先查分布式redis缓存，再查本地缓存,最后再查数据库
        String userinfoString = redisService.getStr("userinfo:"+id);
        UserInfo userInfo = null;
        if(StringUtils.isBlank(userinfoString)){
            userInfo = userService.findUserById(id);
            String userinfoJson = JSONObject.toJSONString(userInfo);
            redisService.setStr("userinfo:"+id,userinfoJson);
            System.out.println("redis无数据，查本地数据");
        }else {
            userInfo = JSONObject.parseObject(userinfoString,UserInfo.class);
            System.out.println("redis有数据，直接返回");
        }
        model.addAttribute("userinfo",userInfo);
        return "viewUser";
    }

    @RequestMapping(value = "toupdateUserById")
    public  String toupdateUserById(long id, Model model) {
        UserInfo userInfo = userService.findUserById(id);
        model.addAttribute("userinfo",userInfo);
        return "updateUser";
    }

    @RequestMapping(value = "updateUserById",method = RequestMethod.POST)
    public void updateUserById(UserInfo userinfo){
            userService.updateUserById(userinfo);
    }

    @RequestMapping(value = "toLogin")
    public String toLogin() {
        return "beautiful/login2";
    }

    @RequestMapping(value = "login",method = RequestMethod.POST)
    public String login(String account,String passw,Model model){
        Map<String,String> resultMap = userService.login(account,passw);
        String reuslt = resultMap.get("result");
        String message = resultMap.get("message");
        if(!"true".equals(reuslt)){
            model.addAttribute("message",message);
            return "loginFail";
        }
        return "loginSuccess";
    }





}
