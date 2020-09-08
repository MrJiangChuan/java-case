package com.jc.dao;

import com.jc.entity.Account;

import java.util.List;

public interface AccountDao {

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
}
