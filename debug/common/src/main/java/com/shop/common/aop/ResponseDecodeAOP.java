package com.shop.common.aop;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.shop.common.ResponseJSON;
import com.shop.common.StateCode;
import com.shop.common.exception.FallbackException;
import com.shop.common.exception.NoAuthorityException;
import com.shop.common.exception.NoFoundException;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class ResponseDecodeAOP {
    @Pointcut("@annotation(com.shop.common.annotation.ResponseDecode)")
    public void pointCut() {
    }

    @Around("pointCut()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        Object[] args = joinPoint.getArgs();
        String jsonString = (String) joinPoint.proceed(args);
        JSONObject jsonObject = JSON.parseObject(jsonString);

//        System.out.println(jsonString);
        switch (jsonObject.getInteger("stateCode")) {
            case StateCode.SUCCESS: {
                return jsonObject.get("data");
            }
            case StateCode.NO_AUTHORITY: {
                throw new NoAuthorityException();
            }
            case StateCode.SERVER_FALLBACK: {
                throw new FallbackException();
            }
            case StateCode.NO_FOUND:{
                throw new NoFoundException();
            }
            default: {
                throw new UnknownError(jsonObject.getString("data"));
            }
        }
    }
}