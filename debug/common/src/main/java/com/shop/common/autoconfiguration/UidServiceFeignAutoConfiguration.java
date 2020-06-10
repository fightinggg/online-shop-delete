package com.shop.common.autoconfiguration;


import com.shop.common.service.impl.UidFallbackService;
import com.shop.common.service.UidService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Slf4j
@Configuration
@ConditionalOnWebApplication
@EnableFeignClients(basePackageClasses = UidService.class)
@EnableCircuitBreaker
public class UidServiceFeignAutoConfiguration {
    @PostConstruct
    public void initMethod() {
        log.info("自动注入Uid");
    }

    @Bean
    UidFallbackService getUidFallbackService(){
        return new UidFallbackService();
    }
}
