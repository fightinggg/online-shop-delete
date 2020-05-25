package com.shop.common.exception;

public class NoAuthorityException extends Exception {
    public NoAuthorityException() {
        super("对不起！没有权限！");
    }
}
