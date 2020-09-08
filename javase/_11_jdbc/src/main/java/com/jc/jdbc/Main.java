package com.jc.jdbc;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.jc.entity.Account;
import com.jc.utils.JdbcUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class Main {

    public static void main(String[] args) {
//        jdbc_update();
//        jdbc_select();
//        jdbc_druid();
//        jdbc_testdruid();
//        jdbcTemplate_insert();
        jdbcTemplate_query();
    }

    private static void jdbcTemplate_query() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(JdbcUtils.getDataSource());

        Long aLong = jdbcTemplate.queryForObject("select count(*) from account", Long.class);
        System.out.println(aLong);
        Account account = jdbcTemplate.queryForObject("select * from account where id=?", new BeanPropertyRowMapper<Account>(Account.class), 3);
        System.out.println(account);
        List<Account> query = jdbcTemplate.query("select * from account", new BeanPropertyRowMapper<Account>(Account.class));
        System.out.println(query);
        List<Account> query1 = jdbcTemplate.query("select * from account where id<?", new RowMapper<Account>() {

            @Override
            public Account mapRow(ResultSet rs, int rowNum) throws SQLException {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                BigDecimal balance = rs.getBigDecimal("balance");
                return new Account(id, name, balance);
            }
        },3);
        System.out.println(query1);
    }

    private static void jdbcTemplate_insert() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(JdbcUtils.getDataSource());
        String sql = "insert into account values(?,?,?)";
        int rt = jdbcTemplate.update(sql, null, "Kitty", 1800);
        System.out.println(rt);
    }

    private static void jdbc_testdruid() {
        for (int i = 0; i < 300; i++) {
            try {
                System.out.println(JdbcUtils.getConnection());
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
            }
        }
    }

    private static void jdbc_druid() {
        Connection connection = null;
        PreparedStatement pst = null;
        ResultSet rst = null;
        try {
            Properties pro = new Properties();
            pro.load(Main.class.getClassLoader().getResourceAsStream("druid.properties"));
            DataSource dataSource = DruidDataSourceFactory.createDataSource(pro);
            connection = dataSource.getConnection();
            String sql = "select * from account";
            pst = connection.prepareStatement(sql);
            rst = pst.executeQuery();
            List<Account> list = new ArrayList<>();
            while (rst.next()) {
                int id = rst.getInt("id");
                String name = rst.getString("name");
                BigDecimal balance = rst.getBigDecimal("balance");
                list.add(new Account(id, name, balance));
            }
            System.out.println(list);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rst != null) {
                try {
                    rst.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (pst != null) {
                try {
                    pst.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }

            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static void jdbc_select() {
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rst = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://192.168.48.120:3306/db1", "jc", "Mycat#666");
            String sql = "select * from account where id<?";
            pst = conn.prepareStatement(sql);
            pst.setInt(1, 3);
            rst = pst.executeQuery();
            List<Account> listAccount = new ArrayList<>();
            while (rst.next()) {
                int id = rst.getInt("id");
                String name = rst.getString("name");
                BigDecimal balance = rst.getBigDecimal("balance");
                listAccount.add(new Account(id, name, balance));
            }
            System.out.println(listAccount);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rst != null) {
                try {
                    rst.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (pst != null) {
                try {
                    pst.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    private static void jdbc_update() {
        Connection conn = null;
        Statement st = null;
        try {
            //1.加载jdbc驱动
//            Class.forName("com.mysql.jdbc.Driver");
            //2.获取连接对象
            conn = DriverManager.getConnection("jdbc:mysql://192.168.48.120/db1", "jc", "Mycat#666");
            conn.setAutoCommit(false);
            //3.编写sql语句
            String sql1 = "update account set balance=balance-500 where id=1";
            String sql2 = "update account set balance=balance+500 where id=2";
            //4.获取sql执行对象statement
            st = conn.createStatement();
            //5.执行sql
            int i = st.executeUpdate(sql1);
            int i1 = st.executeUpdate(sql2);
            conn.commit();
        } catch (Exception e) {
            e.printStackTrace();
            try {
                conn.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } finally {
            //6.释放资源
            if (st != null) {
                try {
                    st.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

        }
    }

}
