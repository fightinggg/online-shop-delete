package com.shop.common.autoconfiguration;

import feign.FeignException;
import feign.Logger;
import feign.Request;
import feign.Response;
import feign.codec.DecodeException;
import feign.codec.Decoder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;

@Slf4j
@Configuration
@ConditionalOnWebApplication
public class MyFeignAutoConfiguration {


    public static final int CONNECT_TIMEOUT_MILLIS = 5000;
    public static final int READ_TIMEOUT_MILLIS = 5000;

    @PostConstruct
    public void initMethod() {
        log.info("自动配置Feign");
    }


    @Bean
    public Decoder feignDecoder() {
        return new Decoder() {
            @Override
            public Object decode(Response response, Type type) throws IOException, DecodeException, FeignException {
                if (response.status() != 200) throw FeignException.errorStatus("fuckkkkkk", response);
                InputStream inputStream = response.body().asInputStream();
                int size = inputStream.available();
                byte[] bytes = new byte[size];
                inputStream.read(bytes);
                return new String(bytes);
            }
        };
    }


    @Bean
    public Logger.Level feignLogger() {
        return Logger.Level.FULL;
    }

    @Bean
    public Request.Options options() {
        return new Request.Options(CONNECT_TIMEOUT_MILLIS, READ_TIMEOUT_MILLIS);
    }
}


