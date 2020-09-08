package com.jc.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.omg.CORBA.PUBLIC_MEMBER;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JdbcUtils {

   private static DataSource dataSource;

   static {
       try {
           Properties pro = new Properties();
           pro.load(JdbcUtils.class.getClassLoader().getResourceAsStream("druid.properties"));
           dataSource = DruidDataSourceFactory.createDataSource(pro);
       } catch (Exception e) {
           e.printStackTrace();
       } finally {
       }
   }

   public static DataSource getDataSource(){
       return dataSource;
   }

   public static Connection getConnection() throws SQLException {
       return dataSource.getConnection();
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
