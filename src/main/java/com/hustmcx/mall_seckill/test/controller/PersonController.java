package com.hustmcx.mall_seckill.test.controller;


import com.hustmcx.mall_seckill.test.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ResponseBody;

//@Controller
public class PersonController {

    @Autowired
    PersonService personService;

    // 设置访问路由值为路径
    @ResponseBody
//    @RequestMapping("/")
    public String index() {
        System.out.println(personService);
        return "ok";
    }


}
