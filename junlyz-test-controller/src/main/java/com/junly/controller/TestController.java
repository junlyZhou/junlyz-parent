package com.junly.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author: Administrator
 * @Date: 2019/5/5 0005 22:30
 * @Description:
 */
@RestController
public class TestController {

    @Autowired
    protected HttpServletRequest request;

    @Autowired
    protected HttpServletResponse response;

    @RequestMapping("/test")
    public Object testController(){
        String token = request.getHeader("token");
        return token;
    }

}
