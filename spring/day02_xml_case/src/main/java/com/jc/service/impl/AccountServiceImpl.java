package com.jc.service.impl;

import com.jc.dao.AccountDao;
import com.jc.entity.Account;
import com.jc.service.AccountService;

import java.util.List;

public class AccountServiceImpl implements AccountService {

    private AccountDao accountDao;

    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

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
