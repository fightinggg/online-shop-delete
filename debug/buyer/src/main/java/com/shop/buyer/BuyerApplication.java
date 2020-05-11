package com.shop.buyer;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

@SpringBootApplication
@EnableDiscoveryClient
@EnableCircuitBreaker
@MapperScan({"com.shop.buyer.dao", "com.shop.buyer.mapper"})
@EnableRedisHttpSession
public class BuyerApplication {

    public static void main(String[] args) {
        SpringApplication.run(BuyerApplication.class, args);
    }

}
