package com.shop.goods;

import com.shop.common.annotation.ResponseEncode;
import com.shop.common.exception.FallbackException;
import com.shop.common.exception.NoAuthorityException;
import com.shop.goods.service.UidService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableDiscoveryClient  // 发现
@EnableCircuitBreaker // 断路器
@MapperScan({"com.shop.goods.dao", "com.shop.goods.mapper"})
@EnableCaching // 启动缓存
@EnableSwagger2 // 启动文档
@EnableFeignClients //启动Feign
@RestController
@EnableAspectJAutoProxy(exposeProxy = true)
public class GoodsApplication {
    public static void main(String[] args) {
        SpringApplication.run(GoodsApplication.class, args);
    }

    @Autowired
    UidService uidService;

    @GetMapping("/hello/{id}")
    @ResponseEncode
    String hello(@PathVariable int id) throws Exception {
        if (id == 1) {
            return "hello";
        } else if (id == 2) {
            throw new NoAuthorityException();
        } else if (id == 3) {
            throw new FallbackException();
        } else if (id == 4) {
            try {
                return uidService.getUid().toString();
            } catch (FallbackException fallbackException) {
                fallbackException.printStackTrace();
                return "fuck";
            }
        } else if (id == 5) {
            return uidService.getUid().toString();
        } else {
            throw new Exception("why");
        }
    }

}