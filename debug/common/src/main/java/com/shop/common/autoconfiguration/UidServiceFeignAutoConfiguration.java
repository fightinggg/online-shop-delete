package com.shop.common.autoconfiguration;


import com.shop.common.service.impl.UidFallbackService;
import com.shop.common.service.UidService;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnWebApplication
@EnableFeignClients(basePackageClasses = UidService.class)
@EnableCircuitBreaker
public class UidServiceFeignAutoConfiguration {
    /**
     *
     * @return
     * 加入断路器
     */
    @Bean
    UidFallbackService getUidFallbackService(){
        return new UidFallbackService();
    }
}
