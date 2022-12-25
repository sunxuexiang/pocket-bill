package com.cloudfly.start.bill.aop;

import com.cloudfly.start.bill.utils.R;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @BelongsProject: pocket-bill
 * @BelongsPackage: com.cloudfly.start.bill.aop
 * @Author: wangyun
 * @CreateTime: 2022-12-25  21:09
 * @Description: TODO
 */

@Aspect
@Component
public class GlobalExceptionAopCatch {

    private Logger logger= LoggerFactory.getLogger(GlobalExceptionAopCatch.class);
    @Pointcut("execution(* com.cloudfly.start.bill.controller.*.*(..))")
    public void globalExceptionCatch(){

    }

    @Around("globalExceptionCatch()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable{
        try{
            return joinPoint.proceed();
        }catch (Exception e){
            MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
            String methodName=methodSignature.getMethod().getDeclaringClass().getName()+"#"+
                    methodSignature.getMethod().getName();
            logger.error(methodName+" occur exception:{}", ExceptionUtils.getStackTrace(e));
            throw e;
        }
    }
}


