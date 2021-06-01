package com.w2s.poc.config;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableCaching
public class EhcacheConfig {

//    @Bean
//    public KeyGenerator customKeyGenerator() {
//        return (Object target, Method method, Object... params) ->
//                method.getName() + "_" + Arrays.toString(params);
//    }

}
