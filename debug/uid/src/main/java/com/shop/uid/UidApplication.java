package com.shop.uid;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan({"com.shop.uid.mapper"})
public class UidApplication {

    public static void main(String[] args) {
        SpringApplication.run(UidApplication.class, args);
    }

}
