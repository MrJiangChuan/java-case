package com.jc.test;

import com.jc.entity.Account;
import com.jc.service.AccountService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class TransTest {

    @Test
    public void transforTest(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        AccountService accountService = (AccountService) ac.getBean("accountService");
        accountService.transfor(1,2,300f);
    }
}
