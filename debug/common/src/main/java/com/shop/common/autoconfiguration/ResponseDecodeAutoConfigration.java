package com.shop.common.autoconfiguration;

import com.shop.common.aop.ResponseDecodeAOP;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnWebApplication
public class ResponseDecodeAutoConfigration {
    @Bean
    ResponseDecodeAOP getResponseDecodeAOP() {
        return new ResponseDecodeAOP();
    }
}
