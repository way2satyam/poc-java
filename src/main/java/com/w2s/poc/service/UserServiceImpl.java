package com.w2s.poc.service;

import com.w2s.poc.Meta;
import com.w2s.poc.dto.UserData;
import com.w2s.poc.dto.mapper.UserMapper;
import com.w2s.poc.model.User;
import com.w2s.poc.repository.UserRepository;
import com.w2s.poc.utils.KeyGen;
import org.apache.logging.log4j.util.Strings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
@Qualifier("userServiceImpl")
public class UserServiceImpl implements UserService {
    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserRepository repository;

    @Cacheable(cacheNames = "users", key = "#id", unless = "#result == null")
    public User getUser(String id) {
        User user = repository.findById(id);
        logger.debug("Get user by id : {} -> {}",
                id, user);
        return user;
    }

    public User saveUser(User user) {
        if (Strings.isBlank(user.getId())) {
            user.setId(KeyGen.generateUUIDKey(Meta.GENERATE_ID_TYPE_USER));
            user.setCreatedTime(Instant.now());
        }
        user.setModifiedTime(Instant.now());
        logger.debug("Save user : {}",
                user);
        return repository.save(user);
    }

    @CacheEvict(cacheNames = "users", key = "#id")
    public User updateUser(User user) {
        return saveUser(user);
    }

    @CacheEvict(cacheNames = "users", key = "#id")
    public void lockById(String id) {
        logger.debug("Lock user by id : {}", id);
        repository.lockById(id);
    }


    public void enableUser(String id) {
        logger.debug("Enable user by id : {}", id);
        repository.enableById(id);
    }

    @CacheEvict(cacheNames = "users", key = "#id")
    public void disableUser(String id) {
        logger.debug("Disable user by id : {}", id);
        repository.disableById(id);
    }

    public UserData getUserData(String id) {
        User user = getUser(id);
        UserData userData = UserMapper.convertUserToUserData(user);
        return userData;
    }

    public User updateUserData(UserData userData) {
        User user = getUser(userData.getId());
        user = UserMapper.convertUserDataToUser(userData, user);
        return updateUser(user);
    }


}
