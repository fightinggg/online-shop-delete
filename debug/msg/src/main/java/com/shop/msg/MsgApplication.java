package com.shop.msg;


import com.shop.common.annotation.enable.EnableResponseEncodeAutoConfigration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableResponseEncodeAutoConfigration
public class MsgApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsgApplication.class, args);
    }

}
