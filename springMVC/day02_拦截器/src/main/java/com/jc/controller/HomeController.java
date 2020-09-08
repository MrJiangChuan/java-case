package com.jc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home")
public class HomeController {

    @RequestMapping("/test1")
    public String test1(){
        System.out.println("HomeController执行了...");
        return "success";
    }
}
