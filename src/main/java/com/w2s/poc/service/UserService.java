package com.w2s.poc.service;

import com.w2s.poc.bean.User;
import com.w2s.poc.dto.UserData;
import com.w2s.poc.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserRepository repository;

    public User getUser(String id) {
        Optional<User> user = repository.findById(id);
        logger.info("get user by {} from db is : {}",
                id,user);
        return user.orElse(null);
    }


    public User saveUser(User user) {
        repository.save(user);
        logger.info("save user to db : {}",
                user);
        return user;
    }

    public void deleteUser(String id) {
        logger.info("delete user from db by {}");
        repository.deleteById(id);
    }


    public UserData getUserData(String id) {
        User user = getUser(id);
        if(user!=null){
            return getUserData(user);
        }
        return null;
    }

    public UserData getUserData(User user) {
        return UserData.builder()
                .id(user.getId())
                .name(user.getName())
                .username(user.getUsername())
                .userNumber(user.getUserNumber())
                .email(user.getEmail())
                .mobile(user.getMobile())
                .coverIcon(user.getCoverIcon())
                .coverImage(user.getCoverImage())
                .createdTime(user.getCreatedTime())
                .modifiedTime(user.getModifiedTime())
                .build();
    }
}
