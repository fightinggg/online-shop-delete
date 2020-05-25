package com.shop.common.aop;

import com.shop.common.ResponseJSON;
import com.shop.common.StateCode;
import com.shop.common.exception.FallbackException;
import com.shop.common.exception.NoAuthorityException;
import com.shop.common.exception.NoFoundException;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
public class ResponseEncodeAOP {

    @Pointcut("@annotation(com.shop.common.annotation.ResponseEncode)")
    public void pointCut() {
    }

    @Around("pointCut()")
    public Object around(ProceedingJoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        try {
            return ResponseJSON.encode(StateCode.SUCCESS, joinPoint.proceed(args));
        } catch (FallbackException e) {
            return ResponseJSON.encode(StateCode.SERVER_FALLBACK, e.getMessage());
        } catch (NoAuthorityException e) {
            return ResponseJSON.encode(StateCode.NO_AUTHORITY, e.getMessage());
        } catch (NoFoundException e) {
            return ResponseJSON.encode(StateCode.NO_FOUND, e.getMessage());
        } catch (Throwable throwable) {
            return ResponseJSON.encode(StateCode.UNKNOWN_SREVER_ERROR, throwable.getMessage());
        }
    }
}
