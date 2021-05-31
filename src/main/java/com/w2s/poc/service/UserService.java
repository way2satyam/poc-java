package com.w2s.poc.service;

import com.w2s.poc.dto.UserData;
import com.w2s.poc.model.User;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;


public interface UserService {

    User getUser(String id);

    User saveUser(User user);

    void enableUser(String id);

    @CacheEvict(cacheNames = "users", key = "#id")
    void lockById(String id);

    @CacheEvict(cacheNames = "users", key = "#id")
    User updateUser(User user);

    @CacheEvict(cacheNames = "users", key = "#id")
    void disableUser(String id);

    @Cacheable(cacheNames = "users", key = "#id", unless = "#result == null")
    UserData getUserData(String id);


}
