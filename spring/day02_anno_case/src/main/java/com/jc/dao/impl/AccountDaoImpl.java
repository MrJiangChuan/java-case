package com.jc.dao.impl;

import com.jc.dao.AccountDao;
import com.jc.entity.Account;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.beans.PropertyVetoException;
import java.sql.SQLException;
import java.util.List;

@Repository("accountDao")
public class AccountDaoImpl implements AccountDao {

    @Autowired
    private QueryRunner qr;

//    private static ComboPooledDataSource cp;

//    private QueryRunner qr = new QueryRunner(cp);

//    static {
//        try {
//            cp = new ComboPooledDataSource();
//            cp.setDriverClass("com.mysql.jdbc.Driver");
//            cp.setJdbcUrl("jdbc:mysql://192.168.48.120:3306/spring");
//            cp.setUser("jc");
//            cp.setPassword("Mycat#666");
//        } catch (PropertyVetoException e) {
//            throw new RuntimeException(e);
//        }
//    }

    public List<Account> findAll() {
        try {
            List<Account> query = qr.query("select * from account", new BeanListHandler<Account>(Account.class));
            return query;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Account findOne(Integer id) {
        try {
            Account query = qr.query("select * from account where id = ?", new BeanHandler<Account>(Account.class), id);
            return query;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void insert(Account account) {
        try {
            qr.update("insert into account values(?,?,?)",null,account.getName(),account.getMoney());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void update(Account account) {
        try {
            qr.update("update account set name = ?, money = ? where id = ?",account.getName(),account.getMoney(),account.getId());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void delete(Integer id) {
        try {
            qr.update("delete from account where id = ?",id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
