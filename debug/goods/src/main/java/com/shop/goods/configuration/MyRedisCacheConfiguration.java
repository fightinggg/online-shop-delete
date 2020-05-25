package com.shop.goods.configuration;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.shop.goods.enums.RedisTime;
import org.springframework.cache.CacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.cache.RedisCacheWriter;
import org.springframework.data.redis.connection.RedisConnectionFactory;

import java.lang.reflect.Field;
import java.time.Duration;


@Configuration
public class MyRedisCacheConfiguration {
    @Bean
    public CacheManager cacheManager(RedisConnectionFactory connectionFactory) {
        RedisCacheConfiguration defaultCacheConfig = RedisCacheConfiguration.defaultCacheConfig()
                .entryTtl(Duration.ofMinutes(10)).disableCachingNullValues();

        RedisCacheWriter redisCacheWriter = RedisCacheWriter.nonLockingRedisCacheWriter(connectionFactory);

        ImmutableSet.Builder<String> cacheNames = ImmutableSet.builder();
        ImmutableMap.Builder<String, RedisCacheConfiguration> cacheConfig = ImmutableMap.builder();

        // 读取时间信息
        for (Field field : RedisTime.class.getDeclaredFields()) {
            try {
                String time = (String) field.get(null);
                cacheNames.add(time);
                cacheConfig.put(time, defaultCacheConfig.entryTtl(Duration.parse(time)));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        return RedisCacheManager.builder(redisCacheWriter)
                .cacheDefaults(defaultCacheConfig)
                .initialCacheNames(cacheNames.build())
                .withInitialCacheConfigurations(cacheConfig.build())
                .build();
    }

}
