package com.cloudfly.start.bill.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

@Configuration
//@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class})
public class DataSourceConfig {

    @Bean
    @Primary
    public DataSource druidDataSrouce(){
        DruidDataSource dds=new DruidDataSource();
        dds.setUrl("jdbc:mysql://localhost:3306/pockit-bill?useUnicode=true&characterEncoding=UTF-8&serverTimezone=Asia/Shanghai");
        dds.setUsername("root");
        dds.setPassword("root1234");
        dds.setInitialSize(10);
        dds.setMaxActive(100);
        dds.setMaxWait(6000);
        dds.setPoolPreparedStatements(true);
        dds.setMaxPoolPreparedStatementPerConnectionSize(20);
        dds.setTimeBetweenEvictionRunsMillis(60000);
        dds.setMinEvictableIdleTimeMillis(300000);
        dds.setTestWhileIdle(true);
        dds.setTestOnBorrow(false);
        dds.setTestOnReturn(false);
        return dds;
    }
}
