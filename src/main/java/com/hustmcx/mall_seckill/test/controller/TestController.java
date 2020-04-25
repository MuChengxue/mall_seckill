package com.hustmcx.mall_seckill.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/test")
public class TestController {

    @RequestMapping(path = "/")
    public String hello() {
        System.out.println("get link");
        return "hello";
    }

}
