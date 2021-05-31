package com.w2s.poc.service;

import com.w2s.poc.Meta;
import com.w2s.poc.bean.User;
import com.w2s.poc.dto.UserData;
import com.w2s.poc.repository.UserRepository;
import com.w2s.poc.utils.KeyGen;
import org.apache.logging.log4j.util.Strings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Optional;


public interface UserService {

    public User getUser(String id);

    public User saveUser(User user);

    @CachePut(cacheNames = "users", key = "#user.id")
    public User updateUser(User user);

    @CacheEvict(cacheNames = "users", key = "#id")
    public void deleteUser(String id);

    public void enableUser(String id);

    @CacheEvict(cacheNames = "users", key = "#id")
    public void disableUser(String id);


    @Cacheable(cacheNames = "users", key = "#id")
    default public UserData getUserData(String id){
        User user = getUser(id);
        return getUserData(user);
    };

    public UserData getUserData(User user);
}
