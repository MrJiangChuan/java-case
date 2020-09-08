package com.jc.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * spring的配置类，相当于bean.xml
 */
@Configuration
@ComponentScan("com.jc")
@Import({JdbcConfig.class, TxManagerConfig.class})
@EnableTransactionManagement
@PropertySource("jdbcConfig.properties")
public class SpringConfig {


}
