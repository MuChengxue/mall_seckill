package com.hustmcx.mall_seckill.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("adminHome")
public class AdminHomeController {

    @RequestMapping("/home")
    public String toAdminHome() {
        return "/adminPage/home";
    }
}
