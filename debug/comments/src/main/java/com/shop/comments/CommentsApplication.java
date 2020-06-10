package com.shop.comments;

import com.shop.common.annotation.enable.EnableUidServiceFeignAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@EnableCircuitBreaker
@EnableUidServiceFeignAutoConfiguration
public class CommentsApplication {

    public static void main(String[] args) {

        SpringApplication.run(CommentsApplication.class, args);
    }

}
