package com.shop.common.autoconfiguration;

import com.shop.common.service.impl.KafkaProduceService;
import com.shop.common.service.impl.PublicMsgProduceService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.context.annotation.Import;

import javax.annotation.PostConstruct;

@Slf4j
@ConditionalOnWebApplication
@EnableBinding(KafkaProduceService.class)
@Import(PublicMsgProduceService.class)
public class PublicMsgProduceServiceAutoConfiguration {
    @PostConstruct
    public void initMethod() {
        log.info("自动装配Kafka流-PublicMsgProduceServiceAutoConfiguration");
    }

}
