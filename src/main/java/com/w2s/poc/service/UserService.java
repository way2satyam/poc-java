package com.w2s.poc.service;

import com.w2s.poc.dto.UserData;
import com.w2s.poc.model.User;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;


public interface UserService {

    void enableUser(String id);

    @CacheEvict(cacheNames = "users", key = "#id")
    void lockById(String id);

    @CacheEvict(cacheNames = "users", key = "#id")
    void disableUser(String id);

    @Cacheable(cacheNames = "users", key = "#id", unless = "#result == null")
    UserData getUserData(String id);

    @CacheEvict(cacheNames = "users", key = "#id")
        //TODO:Enable transaction for this
    User updateUserData(UserData user);


}
