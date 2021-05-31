package com.w2s.poc.service;

import com.w2s.poc.model.User;
import com.w2s.poc.dto.UserData;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;


public interface UserService {

    public User getUser(String id);

    public User saveUser(User user);

    public void enableUser(String id);

    @CacheEvict(cacheNames = "users", key = "#id")
    public void deleteUser(String id);

    @CacheEvict(cacheNames = "users", key = "#id")
    public User updateUser(User user);

    @CacheEvict(cacheNames = "users", key = "#id")
    public void disableUser(String id);

    @Cacheable(cacheNames = "users", key = "#id", unless="#result == null")
    public UserData getUserData(String id);


}
