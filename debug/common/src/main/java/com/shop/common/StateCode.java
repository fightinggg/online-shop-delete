package com.shop.common;


public class StateCode {
    // 成功
    public static final int SUCCESS = 1;

    //请求内容错误
    public static final int REQUEST_CONTEXT_ERROR = 2;

    // 权限不足
    public static final int NO_AUTHORITY = 3;

    // 服务器熔断
    public static final int SERVER_FALLBACK = 4;

    // 未知的服务器错误
    public static final int UNKNOWN_SREVER_ERROR = 5;

    // 资源找不到了
    public static final int NO_FOUND = 6;

    // 没有登陆
    public static final int NO_AUTHENTICATED = 7;
}
