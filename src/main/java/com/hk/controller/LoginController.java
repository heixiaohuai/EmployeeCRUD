package com.hk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @Classname LoginController
 * @Description TODO
 * @Date 2019/8/22 11:28
 * @Created by 13055
 */
@RequestMapping(value = "/user")
@Controller
public class LoginController {

    @PostMapping(value = "/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        Map<String, Object> map,
                        HttpSession session){
        if (!StringUtils.isEmpty(username) && "123".equals(password)){
            session.setAttribute("loginUser", username);
            return "redirect:/main.html";
        }
        else{
            map.put("message", "用户名错误");
        }
        return "index";
    }
}
