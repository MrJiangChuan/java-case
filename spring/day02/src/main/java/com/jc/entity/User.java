package com.jc.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import javax.annotation.Resources;

@Component("user")
//@Controller
//@Service("sevice")
//@Repository("Repository")
//@Scope("prototype")
public class User {
    @Value("1")//基本类型、String
    private Integer id;
    @Value("Tom")
    private String name;
    @Value("18")
    private Integer age;
    @Value("男")
    private String sex;

    @Autowired//自动注入类型相同的
//    @Qualifier("tool")//有多个类型相同的对象时，按id注入

//    @Resource(name="tool")//直接按id注入
    private Tool tool;

    public User() {
        System.out.println("创建对象USER");
    }

    public void useTool(){
        System.out.println("使用工具名称："+tool.getName());
    }
    public User(Integer id, String name, Integer age, String sex) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                '}';
    }

    @PostConstruct
    public void init(){
        System.out.println("init...");
    }

    @PreDestroy
    public void destroy(){
        System.out.println("destroy....");
    }
}
