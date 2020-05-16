package com.shop.uid.config;

import com.shop.uid.service.DisposableWorkerIdAssigner;
import com.xfvape.uid.UidGenerator;
import com.xfvape.uid.impl.CachedUidGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UidConfig {
    @Bean
    public UidGenerator cacheUidGenerator(DisposableWorkerIdAssigner disposableWorkerIdAssigner){
        CachedUidGenerator cachedUidGenerator = new CachedUidGenerator();
        cachedUidGenerator.setWorkerIdAssigner(disposableWorkerIdAssigner);
        return  cachedUidGenerator;
    }
}