package com.shop.common.annotation.enable;

import com.shop.common.autoconfiguration.MyFeignAutoConfiguration;
import com.shop.common.autoconfiguration.ResponseDecodeAutoConfigration;
import com.shop.common.autoconfiguration.UidServiceFeignAutoConfiguration;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@ImportAutoConfiguration({UidServiceFeignAutoConfiguration.class,
        MyFeignAutoConfiguration.class,
        ResponseDecodeAutoConfigration.class})
public @interface EnableUidServiceFeignAutoConfiguration {
}
