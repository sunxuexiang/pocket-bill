package com.cloudfly.start.bill.utils;

import com.google.common.cache.CacheBuilder;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class JwtInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("token");
//        Integer userId =(Integer) CacheBuilder.newBuilder().build().getIfPresent(token);
//        if (null == userId) {
//            throw new Exception("登录过期请重新登录");
//        }
        return true;
    }
}
