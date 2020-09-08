package com.jc.service.impl;

import com.jc.dao.AccountDao;
import com.jc.entity.Account;
import com.jc.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("accountService")
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountDao accountDao;

    public List<Account> findAll() {
        return accountDao.findAll();
    }

    public Account findOne(Integer id) {
        return accountDao.findOne(id);
    }

    public void insert(Account account) {
        accountDao.insert(account);
    }

    public void update(Account account) {
        accountDao.update(account);
    }

    public void delete(Integer id) {
        accountDao.delete(id);
    }
}
