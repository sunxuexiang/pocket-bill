package com.cloudfly.start.bill.config;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;
import java.io.IOException;

@Configuration
public class GatherBaseConfiguration {

    @Bean
    public SqlSessionFactoryBean sqlSessionFactory(DataSource druidDataSource) throws IOException {
        SqlSessionFactoryBean ssfb=new SqlSessionFactoryBean();
        ssfb.setDataSource(druidDataSource);
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        ssfb.setMapperLocations(resolver.getResources("classpath:com/cloudfly/start/bill/mapper/*.xml"));
        return ssfb;
    }
}
