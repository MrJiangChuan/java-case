package com.jc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/order")
public class OrderController {

    @RequestMapping("/test1")
    public String test1(){
        System.out.println("OrderController...");
        return "success";
    }
}
