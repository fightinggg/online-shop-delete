package com.shop.uid;

import com.shop.common.annotation.enable.EnableResponseEncodeAutoConfigration;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan({"com.shop.uid.mapper"})
@EnableResponseEncodeAutoConfigration
public class UidApplication {

    public static void main(String[] args) {
        SpringApplication.run(UidApplication.class, args);
    }

}
