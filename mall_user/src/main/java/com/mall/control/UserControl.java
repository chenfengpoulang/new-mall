package com.mall.control;

import com.mall.entity.UserInfo;
import com.mall.service.UserService;
import com.mall.vo.ConstomUserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "userinfo")
public class UserControl {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "toInsertUser")
    public String toInsertUser(){
        return "insertUser";
    }


    @RequestMapping(value = "insertUser")
    public void insertUser(UserInfo userInfo){
        userService.insertUserInfo(userInfo);
    }


    @RequestMapping(value = "findUserById")
    public String findUserById(long id, Model model){
        UserInfo userInfo = userService.findUserById(id);
        model.addAttribute("userinfo",userInfo);
        return "viewUser";
    }

    @RequestMapping(value = "toupdateUserById")
    public  String toupdateUserById(long id, Model model) {
        UserInfo userInfo = userService.findUserById(id);
        model.addAttribute("userinfo",userInfo);
        return "updateUser";
    }

    @RequestMapping(value = "updateUserById")
    public String updateUserById(UserInfo userinfo) {
        userService.updateUserById(userinfo);
        return "redirect:findUserInfoByVo";
    }

    @RequestMapping(value = "findUserInfoByVo")
    public String findUserInfoByVo(ConstomUserInfo constomUserInfo,Model model) {
        List<UserInfo> list = userService.findUserInfoByVo(constomUserInfo);
        model.addAttribute("list",list);
        return "listUser";
    }

    @RequestMapping(value = "toLogin")
    public String toLogin() {
        return "toLoginUser";
    }

    @RequestMapping(value = "login")
    public String login(String account,String passw,Model model) {
        Map<String,String> resultMap = userService.validLogin(account,passw);
        String reuslt = resultMap.get("result");
        String message = resultMap.get("message");
        if(!"true".equals(reuslt)){
            model.addAttribute("message",message);
            return "loginFail";
        }
        return "loginSuccess";
    }
}
