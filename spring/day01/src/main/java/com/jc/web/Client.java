package com.jc.web;


import com.jc.entity.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Client {
    public static void main(String[] args) throws InterruptedException {
        ApplicationContext ac  = new ClassPathXmlApplicationContext("bean.xml");
        User user = (User) ac.getBean("user");
        System.out.println(user);
        Thread.sleep(3000);
        User user2 = (User) ac.getBean("user");
        System.out.println(user2);
        System.out.println(user==user2);
    }
}
