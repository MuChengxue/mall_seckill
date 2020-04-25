package com.hustmcx.mall_seckill.controller;

import com.hustmcx.mall_seckill.model.User;
import com.hustmcx.mall_seckill.service.UserService;
import com.hustmcx.mall_seckill.vo.user.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping(path = "/toAdd")
    public String toAdd() {
        return "/user/add";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addCommit(User user) {
        userService.insertUser(user);
//        System.out.println(user);
//        System.out.println(System.currentTimeMillis());
        return "redirect:queryByVo";
    }

    @RequestMapping("/toUpdate")
    public String toUpdate(Model model, int id) {
        User user = userService.getUserById(id);
        model.addAttribute("user", user);
        return "/user/update";
    }

    @RequestMapping(value = "/update", method = {RequestMethod.POST, RequestMethod.GET})
    public String update(User user) {
//        System.out.println("update");
        userService.updateUser(user);
//        System.out.println(user);
        return "redirect:queryByVo";
    }

    @RequestMapping("/delete")
    //不加@ResponseBody就去找HTML页面去了，可真烦
    public String delete(int id) {
        userService.deleteUserById(id);
        return "redirect:queryByVo";
    }

    @RequestMapping("/query")
    public String query(Model model, int id) {
        User user = userService.getUserById(id);
        System.out.println(user);
        model.addAttribute("user", user);
        return "user/view";
    }

    @RequestMapping("/queryByVo")
    public String queryByVo(Model model, UserVo userVo) {
        List<User> list = userService.queryUserByVo(userVo);
        model.addAttribute("userList", list);
        return "user/list";
    }
}
