package com.timwang5.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginController {

    @RequestMapping("/user/login")

    public String login(@RequestParam("username") String username, @RequestParam("password")String password, Model model){

        //具体业务 判断用户名和密码正确
        if ("admin".equals(username) && "123456".equals(password)){

            //跳转到dashboard页面
            return "dashboard";
        }
        else {
            model.addAttribute("msg", "用户名或者密码错误");
            return "index";
        }
    }
}
