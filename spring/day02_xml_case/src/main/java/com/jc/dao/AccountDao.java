package com.jc.dao;

import com.jc.entity.Account;

import java.util.List;

public interface AccountDao {

    /**
     * 查询所有账户信息
     * @return
     */
    List<Account> findAll();

    /**
     * 按照id查询账户
     * @param id
     * @return
     */
    Account findOne(Integer id);

    /**
     * 增加一个账户
     * @param account
     */
    void insert(Account account);

    /**
     * 修改一个账户
     * @param account
     */
    void update(Account account);

    /**
     * 按照id删除一个账户
     * @param id
     */
    void delete(Integer id);

}
