package com.hk.controller;

import com.hk.exception.UserNotExistException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Classname HelloController
 * @Description TODO
 * @Date 2019/8/23 14:52
 * @Created by 13055
 */
@Controller
public class HelloController {
    @ResponseBody
    @RequestMapping("/hello")
    public String sayHello(@RequestParam("user") String user) {
        if (user.equals("aaa")){
            throw new UserNotExistException();
        }
        return "hello world";
    }
}
