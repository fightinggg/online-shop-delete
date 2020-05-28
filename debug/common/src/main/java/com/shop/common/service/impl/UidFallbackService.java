package com.shop.file.service.impl;

import com.shop.common.annotation.ResponseEncode;
import com.shop.common.exception.FallbackException;
import com.shop.file.service.UidService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class UidFallbackService implements UidService {

    @Override
    @ResponseEncode
    public Long getUid() throws FallbackException {
        log.warn("Uid服务熔断");
        throw new FallbackException();
    }
}
