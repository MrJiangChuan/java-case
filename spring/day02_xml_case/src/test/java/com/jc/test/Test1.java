package com.jc.test;

import com.jc.entity.Account;
import com.jc.service.AccountService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class Test1 {

    @Test
    public void findAll(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        AccountService accountService = (AccountService) ac.getBean("accountService");
        List<Account> all = accountService.findAll();
        for (Account account : all) {
            System.out.println(account);
        }
    }

    @Test
    public void findOne(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        AccountService accountService = (AccountService) ac.getBean("accountService");
        Account one = accountService.findOne(3);
        System.out.println(one);
    }

    @Test
    public void insert(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        AccountService accountService = (AccountService) ac.getBean("accountService");
        accountService.insert(new Account(null,"Tom",12.33f));
    }

    @Test
    public void update(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        AccountService accountService = (AccountService) ac.getBean("accountService");
        accountService.update(new Account(5,"Jerry",1.0f));
    }

    @Test
    public void delete(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        AccountService accountService = (AccountService) ac.getBean("accountService");
        accountService.delete(5);
    }
}
