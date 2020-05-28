package com.shop.common.service;


import com.shop.common.annotation.ResponseDecode;
import com.shop.common.configuration.MyFeignConfiguration;
import com.shop.common.exception.FallbackException;
import com.shop.common.service.impl.UidFallbackService;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "uid", configuration = MyFeignConfiguration.class,fallback = UidFallbackService.class)
public interface UidService {

    @GetMapping("/")
    @ResponseDecode
    Object getUid() throws FallbackException;
}

