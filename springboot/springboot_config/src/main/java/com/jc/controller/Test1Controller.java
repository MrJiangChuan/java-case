package com.jc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Arrays;

@Controller
@RequestMapping("/test")
@ConfigurationProperties(prefix = "student")
public class Test1Controller {

    private int id;
    private String name;
    private int age;

//    @Value("${provinces[0]}")
//    @Autowired
//    @Qualifier("strings")
    @Resource(name="strings")
    private String[] provices;

    @Value("${map[one]}")
    private String one;
    @Value("${map.two}")
    private String two;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @RequestMapping("/test1")
    @ResponseBody
    public String test1(){

        System.out.println(Arrays.toString(provices));
        System.out.println(one+two);
        return "test1...."+this.id+this.name+this.age+Arrays.toString(provices);
    }
}
