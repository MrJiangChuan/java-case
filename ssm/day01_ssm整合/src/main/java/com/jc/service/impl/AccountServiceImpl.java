package com.jc.service.impl;

import com.jc.dao.AccountDao;
import com.jc.entity.Account;
import com.jc.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(propagation= Propagation.REQUIRED, readOnly = false)
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountDao accountDao;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public List<Account> findAll() {
        return accountDao.findAll();
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public Account findOneById(Integer id) {
        return accountDao.findOneById(id);
    }

    @Override
    public int insert(Account account) {
        return accountDao.insert(account);
    }

    @Override
    public int update(Account account) {
        return accountDao.update(account);
    }

    @Override
    public int delete(Integer id) {
        return accountDao.delete(id);
    }
}
