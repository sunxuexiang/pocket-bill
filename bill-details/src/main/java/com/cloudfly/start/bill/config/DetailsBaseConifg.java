package com.cloudfly.start.bill.config;


//import com.alibaba.cloud.nacos.ribbon.NacosRule;
//import com.netflix.loadbalancer.IRule;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.cloudfly.start.bill.mapper")
public class DetailsBaseConifg {

//    @Bean
//    public IRule ribbonRule(){
//        //指定使用nacos的负载均衡配置(优先调用同一集群，基于权重随机)
//        return new NacosRule();
//    }
}
