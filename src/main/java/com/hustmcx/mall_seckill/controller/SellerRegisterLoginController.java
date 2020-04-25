package com.hustmcx.mall_seckill.controller;

import com.hustmcx.mall_seckill.model.Seller;
import com.hustmcx.mall_seckill.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("sellerRegisterLogin")
public class SellerRegisterLoginController {
    @Autowired
    SellerService sellerService;

    @RequestMapping(value = "/toRegister")
    public String toRegister() {
        return "/loginSeller/toRegister";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(HttpServletRequest request, Seller seller) {
        sellerService.insertSeller(seller);
        HttpSession sess = request.getSession();
        sess.setAttribute("seller", seller);
        return "/adminPage/adminPage";
    }

    @RequestMapping(value = "toLogin")
    public String toLogin() {
        return "/loginSeller/toLogin";
    }

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String login(HttpServletRequest request, Seller seller) {
        String returnUrl = "/adminPage/error";
        String account = seller.getAccount();
        String password = seller.getPassword();
        Seller sellerRes = sellerService.getSellerByAccount(account);
        if (sellerRes == null) {
//            System.out.println("无此商家");
            request.setAttribute("errorInfo", "无此商家");
        } else if (!sellerRes.getPassword().equals(password)) {
//            System.out.println("商家密码错误");
            request.setAttribute("errorInfo", "商家密码错误");
        } else {
            HttpSession session = request.getSession();
            session.setAttribute("seller", sellerRes);
            returnUrl = "/adminPage/adminPage";
        }
        return returnUrl;
    }

    @RequestMapping(value = "exit")
    public String exit(HttpServletRequest req) {
        HttpSession sess = req.getSession();
        sess.removeAttribute("seller");
        return "/loginSeller/exit";
    }
}
