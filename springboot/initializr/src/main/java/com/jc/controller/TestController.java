package com.jc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/test")
public class TestController {

    @RequestMapping("test1")
    public String test1(Model model){
        model.addAttribute("user","Tom");
        model.addAttribute("userHtml","<h1>Tom</h1>");
        model.addAttribute("color","red");
        model.addAttribute("link","https://www.baidu.com");
        model.addAttribute("flag",12);
        List<String> list = new ArrayList<>();
        list.add("aa");
        list.add("bb");
        list.add("cc");
        model.addAttribute("list",list);
        return "home";
    }
}
