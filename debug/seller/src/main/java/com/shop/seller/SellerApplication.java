package com.shop.seller;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

@SpringBootApplication
@MapperScan({"com.shop.seller.mapper", "com.shop.seller.dao"})
@EnableRedisHttpSession
public class SellerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SellerApplication.class, args);
    }

}
