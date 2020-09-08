package com.jc.test;

import com.jc.config.SpringConfig;
import com.jc.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AopTest {

    @Test
    public void annotest1(){

        ApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfig.class);
        UserService userService = (UserService) ac.getBean("userService");
        userService.find();
    }

    @Test
    public void xmltest2(){

        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.bak");
        UserService userService = (UserService) ac.getBean("userService");
        userService.find();
    }
}
