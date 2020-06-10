package com.shop.common.autoconfiguration;

import com.shop.common.aop.ResponseEncodeAOP;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Slf4j
@Configuration
@ConditionalOnWebApplication
public class ResponseEncodeAutoConfigration {

    @PostConstruct
    public void initMethod() {
        log.info("自动注入ResponseEncode");
    }


    @Bean
    ResponseEncodeAOP getResponseEncodeAOP() {
        return new ResponseEncodeAOP();
    }
}
