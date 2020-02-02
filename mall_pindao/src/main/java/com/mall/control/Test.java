package com.mall.control;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Test {

    @RequestMapping("hellworld")
    public String hellworld(){
        return "hello world!!";
    }
}