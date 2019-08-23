package com.hk.controller;

import com.hk.exception.UserNotExistException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @Classname MyExceptionHandler
 * @Description TODO
 * @Date 2019/8/23 16:03
 * @Created by 13055
 */
@ControllerAdvice
public class MyExceptionHandler {
    /**
     * @Description 浏览器和手机等客户端都返回JSON数据
     * @param
     * @param e
     * @return java.util.Map<java.lang.String,java.lang.Object>
     * @date 2019/8/23 16:09
     * @author 13055
     */
    /*@ExceptionHandler(UserNotExistException.class)
    @ResponseBody
    public Map<String, Object> handlerException(Exception e){
        Map<String, Object> map = new HashMap<>();
        map.put("status", "500");
        map.put("exception", "com.hk.exception.UserNotExistException");
        map.put("message", e.getMessage());
        return map;
    }*/


    /**
     * @Description 自适应的返回相应的数据（网页则返回错误页面，手机端则返回错误信息的JSON数据）
     * @param
     * @param e
     * @param request
     * @return java.lang.String
     * @date 2019/8/23 17:03
     * @author 13055
     */
    @ExceptionHandler(UserNotExistException.class)
    public String handlerException(Exception e, HttpServletRequest request){
        Map<String, Object> map = new HashMap<>();
        request.setAttribute("javax.servlet.error.status_code", 500);
        map.put("exception", e.getClass());
        map.put("message", e.getMessage());
        request.setAttribute("ext", map);
        return "forward:/error";
    }

}
