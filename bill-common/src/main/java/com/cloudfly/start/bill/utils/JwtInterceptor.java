package com.cloudfly.start.bill.utils;

import com.google.common.cache.CacheBuilder;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class JwtInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        Integer currentLoginUser = JwtUtils.getCurrentLoginUser();
//        if (currentLoginUser == 0) {
//            return false;
//        }
        return true;
    }
}
