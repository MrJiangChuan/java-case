package com.jc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * 和事务相关的配置类
 */
public class TxManagerConfig {

    @Bean(name = "txManager")
    public DataSourceTransactionManager createDataSourceTransactionManager(DataSource dataSource){
        return new DataSourceTransactionManager(dataSource);
    }


}
