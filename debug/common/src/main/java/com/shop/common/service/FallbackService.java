package com.shop.common.service;

import com.shop.common.annotation.ResponseEncode;
import com.shop.common.exception.FallbackException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class FallbackService {
    @ResponseEncode
    public void get(Object ... args) throws FallbackException {
        log.warn("服务熔断");
        throw new FallbackException();
    }
}
