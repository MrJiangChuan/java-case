package com.jc.test;

import com.jc.config.SpringAnnoConfig;
import com.jc.entity.Account;
import com.jc.service.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringAnnoConfig.class)
public class Test2 {

    @Autowired
    private AccountService accountService;

    @Test
    public void findAll(){
        List<Account> all = accountService.findAll();
        for (Account account : all) {
            System.out.println(account);
        }
    }

}
