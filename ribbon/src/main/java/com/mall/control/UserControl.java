package com.mall.control;

import com.mall.entity.ProductTotal;
import com.mall.entity.UserInfo;
import com.mall.service.ProductServiceImpl;
import com.mall.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/user")
public class UserControl {
    @Autowired
    private UserServiceImpl userService;

    @RequestMapping(value = "findById",method = RequestMethod.GET)
    public UserInfo findById(@RequestParam long id){
        UserInfo userById = userService.findUserById(id);
        return userById;
    }

}
