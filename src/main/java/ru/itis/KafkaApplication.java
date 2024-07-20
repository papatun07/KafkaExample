package ru.itis;

import org.redisson.api.RedissonClient;
import org.redisson.codec.JsonJacksonCodec;
import org.redisson.spring.cache.CacheConfig;
import org.redisson.spring.cache.RedissonSpringCacheManager;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;


import java.util.HashMap;
import java.util.Map;


@EnableCaching
@SpringBootApplication
public class KafkaApplication {


    public static void main(String[] args) {
        SpringApplication.run(KafkaApplication.class, args);
    }
}
