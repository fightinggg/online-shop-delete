//package com.shop.common.aop;
//
//import com.shop.common.ResponseJSON;
//import com.shop.common.StateCode;
//import com.shop.common.exception.FallbackException;
//import com.shop.common.exception.NoAuthorityException;
//import org.aspectj.lang.ProceedingJoinPoint;
//import org.aspectj.lang.annotation.Around;
//import org.aspectj.lang.annotation.Aspect;
//import org.aspectj.lang.annotation.Pointcut;
//import org.springframework.core.annotation.Order;
//
//@Aspect
//@Order(1)
//public class FunctionLoggerAOP {
//    @Pointcut("@annotation(com.shop.common.annotation.ResponseEncode)")
//    public void pointCut() {
//    }
//
//    @Around("pointCut()")
//    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
//        System.out.println("FunctionLoggerAOP");
//        Object[] args = joinPoint.getArgs();
//        return joinPoint.proceed(args);
//    }
//}
