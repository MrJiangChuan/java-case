package com.jc.dao.impl;

import com.jc.dao.UserDao;
import com.jc.entity.User;
import com.jc.utils.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDaoImpl implements UserDao {
    @Override
    public boolean userContains(User user) {
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rst = null;
        boolean flag = false;
        try {
            conn = JdbcUtils.getConnection();
            String sql = "select * from user where name=? and password=?";
            pst = conn.prepareStatement(sql);
            pst.setString(1, user.getName());
            pst.setString(2, user.getPassword());
            rst = pst.executeQuery();
            if (rst.next()) {
                flag = true;
            } else {
                flag = false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.close(rst, pst, conn);
            return flag;
        }
    }
}
