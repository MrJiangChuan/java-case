package com.jc.dao.impl;

import com.jc.dao.AccountDao;
import com.jc.entity.Account;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class AccountDaoImpl implements AccountDao {

    JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Account> findAll() {
        List<Account> accounts = null;
        try {
            accounts = jdbcTemplate.query("select * from account", new BeanPropertyRowMapper<Account>(Account.class));
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
        return accounts;
    }

    public Account findOneById(Integer id) {
        Account account = null;
        try {
            account = jdbcTemplate.queryForObject("select * from account where id = ?", new BeanPropertyRowMapper<Account>(Account.class), id);
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
        return account;
    }


    public void insert(Account account) {
        jdbcTemplate.update("insert into account values(?,?,?)",null,account.getName(),account.getMoney());
    }

    public void update(Account account) {
        jdbcTemplate.update("update account set name = ?, money = ? where id = ?",account.getName(),account.getMoney(),account.getId());
    }

    public void delete(Integer id) {
        jdbcTemplate.update("delete from account where id = ?",id);
    }
}
