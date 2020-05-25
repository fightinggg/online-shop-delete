package com.shop.common.exception;

public class FallbackException extends Exception{
    public FallbackException() {
        super("对不起，服务熔断了！");
    }
}
