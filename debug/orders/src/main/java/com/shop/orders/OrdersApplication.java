package com.shop.orders;

import com.shop.common.annotation.enable.EnablePrivateMsgProduceServiceAutoConfiguration;
import com.shop.common.annotation.enable.EnableResponseEncodeAutoConfigration;
import com.shop.common.annotation.enable.EnableUidServiceFeignAutoConfiguration;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;


@SpringBootApplication
@EnableCaching
@EnableResponseEncodeAutoConfigration
@EnableUidServiceFeignAutoConfiguration
@EnablePrivateMsgProduceServiceAutoConfiguration
@MapperScan({"com.shop.orders.dao", "com.shop.orders.mapper"})
public class OrdersApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrdersApplication.class, args);
    }

}
