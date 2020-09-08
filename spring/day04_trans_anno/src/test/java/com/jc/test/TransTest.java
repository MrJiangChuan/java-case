package com.jc.test;

import com.jc.config.SpringConfig;
import com.jc.service.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfig.class)
public class TransTest {

    @Autowired
    private AccountService accountService;

    @Test
    public void transforTest(){
        accountService.transfor(1,2,300f);
    }
}
