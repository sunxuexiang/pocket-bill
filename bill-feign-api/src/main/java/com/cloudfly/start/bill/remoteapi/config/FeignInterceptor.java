package com.cloudfly.start.bill.remoteapi.config;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @Description : TODO
 * @author: Hulk
 * @date : 0718:23
 */
@Configuration
public class FeignInterceptor {

    @Bean("requestInterceptor")
    public RequestInterceptor requestInterceptor(){
        return new RequestInterceptor() {
            @Override
            public void apply(RequestTemplate requestTemplate) {
                // 通过RequestContextHolder拿到用户的request
                ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
                HttpServletRequest request = requestAttributes.getRequest();
                String cookie = request.getHeader("Authorization");
                // 将用户的cookie设置给feign代理后的请求
                requestTemplate.header("Authorization", cookie);
            }
        };
    }
}
