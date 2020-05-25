package com.shop.common.exception;

public class NoFoundException extends  Exception {
    public NoFoundException(){
        super("资源无法找到");
    }
}
