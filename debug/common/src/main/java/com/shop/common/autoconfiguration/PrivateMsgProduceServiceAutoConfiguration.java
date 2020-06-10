package com.shop.common.autoconfiguration;


import com.shop.common.entity.PrivateMsg;
import com.shop.common.service.impl.PrivateMsgProduceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import javax.annotation.PostConstruct;

@Slf4j
@Configuration
@ConditionalOnWebApplication
@Import(PrivateMsgProduceService.class)
public class PrivateMsgProduceServiceAutoConfiguration {
    @PostConstruct
    public void initMethod() {
        log.info("自动注入PrivateMsgProduceService");
    }
}
