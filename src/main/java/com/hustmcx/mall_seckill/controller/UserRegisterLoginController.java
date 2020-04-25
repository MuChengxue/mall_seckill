package com.hustmcx.mall_seckill.controller;


import com.hustmcx.mall_seckill.model.User;
import com.hustmcx.mall_seckill.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/userRegisterLogin")
public class UserRegisterLoginController {
    @Autowired
    UserService userService;

    @RequestMapping(value = "/toRegister")
    public String toRegister() {
        return "/loginUser/toRegister";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(HttpServletRequest request, User user) {
        userService.insertUser(user);
        HttpSession session = request.getSession();
        session.setAttribute("user", user);
        System.out.println(user);
        return "/homePage/homePage";
    }

    @RequestMapping(value = "toLogin")
    public String toLogin() {
        return "/loginUser/toLogin";
    }

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String login(HttpServletRequest request, User user) {
        String returnUrl = "/homePage/error";
        String userAccount = user.getUserAccount();
        String userPassword = user.getUserPassword();
        User userResult = userService.getUserByUserAccount(userAccount);
        if (userResult == null) {
            request.setAttribute("errorInfo", "无此用户");
        } else if (!userResult.getUserPassword().equals(userPassword)) {
            request.setAttribute("errorInfo", "密码错误");
        } else {
            HttpSession sess = request.getSession();
            sess.setAttribute("user", userResult);
            returnUrl = "/homePage/homePage";
        }
        return returnUrl;
    }

    @RequestMapping(value = "/exit")
    public String exit(HttpServletRequest req) {
        HttpSession sess = req.getSession();
        sess.removeAttribute("user");
        return "/loginUser/exit";
    }

}
