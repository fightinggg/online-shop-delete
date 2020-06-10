package com.shop.common.annotation.enable;

import com.shop.common.autoconfiguration.PrivateMsgProduceServiceAutoConfiguration;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@ImportAutoConfiguration(PrivateMsgProduceServiceAutoConfiguration.class)
public @interface EnablePrivateMsgProduceServiceAutoConfiguration {
}
