package com.kou.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

/**
 * Created by KouJiaxing on 2017-10-24.
 */
@Aspect
@Order(1)
@Component
public class TestAspect {

    @Pointcut("execution(public * com.kou.controller.*Controller.*(..))")
    public void joinPointExpression() {

    }

    /**
     * before
     */
    @Before("joinPointExpression()")
    public void beforeMethod(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        List<Object> args = Arrays.asList(joinPoint.getArgs());
        System.out.println("this method" + methodName + " begin. param<" + args + ">");
    }

    /**
     * after
     */
    @After("joinPointExpression()")
    public void afterMethod(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println("this method " + methodName + " end.");
    }


}
