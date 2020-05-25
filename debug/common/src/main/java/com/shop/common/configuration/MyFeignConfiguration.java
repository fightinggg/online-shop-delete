package com.shop.common.configuration;

import feign.Logger;
import feign.Request;
import feign.codec.Decoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.InputStream;

@Configuration
public class MyFeignConfiguration {


    public static final int CONNECT_TIMEOUT_MILLIS = 5000;
    public static final int READ_TIMEOUT_MILLIS = 5000;

    @Bean
    public Decoder feignDecoder() {
        return (response, type) -> {
            InputStream inputStream = response.body().asInputStream();
            int size = inputStream.available();
            byte[] bytes = new byte[size];
            inputStream.read(bytes);
            return new String(bytes);
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
