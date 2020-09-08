package com.jc.controller;

import com.jc.exception.MyException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/exception")
public class ExceptionController {

    @RequestMapping("/expt1")
    public String expt1(){
        throw new MyException("你好骚啊...");
//        return "success";
    }
}
