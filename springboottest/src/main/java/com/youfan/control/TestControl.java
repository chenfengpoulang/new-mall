package com.youfan.control;

import org.hibernate.validator.constraints.pl.REGON;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "testControl")
public class TestControl {

    @RequestMapping(value = "helloWorld",method = RequestMethod.GET)
    public String helloWorld(){
        return "hello !! my name is com.youfan!!";
    }
}
