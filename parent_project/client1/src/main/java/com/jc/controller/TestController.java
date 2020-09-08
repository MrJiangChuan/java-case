package com.jc.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/test")
@RefreshScope
public class TestController {

    @Value("${name}")
    private String name;

    @RequestMapping("/test1")
    public String getUserInfo() {
        return "姜川，男，26,1994-12-23";
    }

    @RequestMapping("/test2")
    public String getheader(HttpServletRequest request) {
        String authorization = request.getHeader("Authorization");
        System.out.println(authorization);
        return authorization;
    }

    @RequestMapping("/test3")
    public String getName() {
        return this.name;
    }
}
