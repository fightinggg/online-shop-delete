package com.shop.common.annotation.enable;

import com.shop.common.autoconfiguration.PublicMsgProduceServiceAutoConfiguration;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;

import javax.annotation.PostConstruct;
import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@ImportAutoConfiguration(PublicMsgProduceServiceAutoConfiguration.class)
public @interface EnablePublicMsgProduceServiceAutoConfiguration {
}
