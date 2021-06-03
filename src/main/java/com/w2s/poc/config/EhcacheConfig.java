package com.w2s.poc.config;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.AdviceMode;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.lang.reflect.Method;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Configuration
@EnableCaching(mode = AdviceMode.ASPECTJ)
public class EhcacheConfig {

    @Bean("custom-key-gen")
    public KeyGenerator customKeyGenerator() {
        return (Object target, Method method, Object... params) -> {
            StringBuilder sb = new StringBuilder();
            sb.append(target.getClass().getSimpleName())
                    .append("-")
                    .append(method.getName());

            if (params != null) {
                String key = Stream.of(params).map(item -> {
                    if (item.getClass().isArray()) {
                        return Stream.of(item)
                                .map(arrItem -> arrItem.hashCode() + "")
                                .collect(Collectors.joining("-"));
                    } else {
                        return item.hashCode() + "";
                    }
                }).collect(Collectors.joining(":"));
                sb.append("-").append(key);
            }
            return sb.toString();
        };
    }

}
