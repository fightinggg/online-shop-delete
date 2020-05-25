package com.shop.common.autoconfiguration;

import com.shop.common.aop.ResponseEncodeAOP;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnWebApplication
public class ResponseEncodeAutoConfigration {
    @Bean
    ResponseEncodeAOP getResponseEncodeAOP() {
        return new ResponseEncodeAOP();
    }
}
