package com.jc.service.impl;

import com.jc.dao.AccountDao;
import com.jc.entity.Account;
import com.jc.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("accountService")
@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountDao accountDao;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public List<Account> findAll() {
        return accountDao.findAll();
    }

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public Account findOneById(Integer id) {
        return accountDao.findOneById(id);
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

    public void transfor(Integer sourceId, Integer targetId, Float money) {
        //查询账户是否存在
        Account sourceAccount = this.findOneById(sourceId);
        Account targetAccount = this.findOneById(targetId);
        if (sourceAccount == null || targetAccount == null) throw new RuntimeException("账户不存在");
        //查询余额是否足够
        float sourceMoney = sourceAccount.getMoney() - money;
        float targetMoney = targetAccount.getMoney() + money;
        if (sourceMoney < 0) throw new RuntimeException("余额不足");
        //转账
        this.update(new Account(sourceAccount.getId(), sourceAccount.getName(), sourceMoney));
//        int a = 1 / 0;
        this.update(new Account(targetAccount.getId(), targetAccount.getName(), targetMoney));
    }

}
