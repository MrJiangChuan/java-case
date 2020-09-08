package com.jc.test;

import com.jc.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AopTest {

    @Test
    public void test1(){

        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        UserService userService = (UserService) ac.getBean("userService");
        userService.find();
    }
}
