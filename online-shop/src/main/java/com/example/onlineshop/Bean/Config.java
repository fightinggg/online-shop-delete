package com.example.onlineshop.Bean;

import com.example.onlineshop.interceptor.BuyerLoginInterceptor;
import com.example.onlineshop.interceptor.SellerLoginInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Component
public class Config {

    @Bean
    public WebMvcConfigurer webMvcConfigurerAdapter() {
        return new WebMvcConfigurer() {
            @Override
            public void addInterceptors(InterceptorRegistry registry) {
                registry.addInterceptor(new BuyerLoginInterceptor()).addPathPatterns("/buyer/**").excludePathPatterns("/buyer/login");
                registry.addInterceptor(new SellerLoginInterceptor()).addPathPatterns("/seller/**").excludePathPatterns("/seller/login");
            }
        };
    }
}
