package com.w2s.poc.config;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.cache.ehcache.EhCacheManagerFactoryBean;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import java.lang.reflect.Method;
import java.util.Arrays;

@Configuration
@EnableCaching
public class EhcacheConfig {

//    @Bean
//    public KeyGenerator customKeyGenerator() {
//        return (Object target, Method method, Object... params) ->
//                method.getName() + "_" + Arrays.toString(params);
//    }

}
