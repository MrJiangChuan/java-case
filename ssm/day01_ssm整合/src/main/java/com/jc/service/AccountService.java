package com.jc.service;

import com.jc.entity.Account;

import java.util.List;

public interface AccountService {
    /**
     * 查询所有账户信息
     *
     * @return
     */
    List<Account> findAll();

    /**
     * 按照id查询账户信息
     *
     * @return
     */
    Account findOneById(Integer id);

    /**
     * 增加账户
     *
     * @param account
     * @return
     */
    int insert(Account account);

    /**
     * 更新账户
     *
     * @param account
     * @return
     */
    int update(Account account);

    /**
     * 删除某个id的账户
     *
     * @param id
     * @return
     */
    int delete(Integer id);
}
