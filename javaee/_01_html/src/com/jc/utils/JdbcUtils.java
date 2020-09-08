package com.jc.utils;

import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class JdbcUtils {
    private static String url;
    private static String user;
    private static String password;

    static {
        try {
            Properties pro = new Properties();
            pro.load(JdbcUtils.class.getClassLoader().getResourceAsStream("jdbc.properties"));
            url = pro.getProperty("url");
            user = pro.getProperty("user");
            password = pro.getProperty("password");
            Class.forName(pro.getProperty("driver"));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url,user,password);
    }

    public static void close(Statement st, Connection conn){
        if(st!=null){
            try {
                st.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(conn!=null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void close(ResultSet rst, Statement st, Connection conn){
        if(rst!=null){
            try {
                rst.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        close(st,conn);
    }
}
