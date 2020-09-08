package com.jc.service;

import com.jc.entity.Account;

import java.util.List;

public interface AccountService {

    /**
     * 查询所有账户
     * @return
     */
    List<Account> findAll();

    /**
     * 按照id查询账户
     * @return
     */
    Account findOneById(Integer id);

    /**
     * 增加账户
     * @param account
     */
    void insert(Account account);

    /**
     * 跟新账户
     * @param account
     */
    void update(Account account);

    /**
     * 删除账户
     * @param id
     */
    void delete(Integer id);

    /**
     * 转账
     * @param sourceId 转出账户
     * @param targetId 转入账户
     * @param money  转出金额
     */
    void transfor(Integer sourceId, Integer targetId, Float money);
}
