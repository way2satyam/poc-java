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
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
@Qualifier("userServiceImpl")
public class UserServiceImpl implements UserService{
    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserRepository repository;


    protected User getUser(String id) {
        User user = repository.findById(id);
        logger.debug("Get user by id : {} -> {}",
                id, user);
        return user;
    }

    protected User saveUser(User user) {
        if (Strings.isBlank(user.getId())) {
            user.setId(KeyGen.generateUUIDKey(Meta.GENERATE_ID_TYPE_USER));
            user.setCreatedTime(Instant.now());
        }
        user.setModifiedTime(Instant.now());
        logger.debug("Save user : {}",
                user);
        return repository.save(user);
    }

    public void lockById(String id) {
        logger.debug("Lock user by id : {}", id);
        repository.lockById(id);
    }

    public void enableUser(String id) {
        logger.debug("Enable user by id : {}", id);
        repository.enableById(id);
    }

    public void disableUser(String id) {
        logger.debug("Disable user by id : {}", id);
        repository.disableById(id);
    }

    public UserData getUserData(String id) {
        User user = getUser(id);
        UserData userData = UserMapper.convertUserToUserData(user);
        logger.debug("Get user data by id : {} -> {}",
                id, userData);
        return userData;
    }

    public User updateUserData(UserData userData) {
        User user = getUser(userData.getId());
        user = UserMapper.convertUserDataToUser(userData, user);
        return saveUser(user);
    }


}
