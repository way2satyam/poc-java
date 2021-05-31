package com.w2s.poc.service;

import com.w2s.poc.config.Meta;
import com.w2s.poc.model.User;
import com.w2s.poc.dto.UserData;
import com.w2s.poc.repository.UserRepository;
import com.w2s.poc.utils.KeyGen;
import lombok.RequiredArgsConstructor;
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
    Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserRepository repository;


    public User getUser(String id) {
        User user = repository.findById(id);
        logger.info("get user by {} from db is : {}",
                id,user);
        return user;
    }

    public User saveUser(User user) {
        if(Strings.isBlank(user.getId())){
            user.setId(KeyGen.generateUUIDKey(Meta.GENERATE_ID_TYPE_USER));
            user.setCreatedTime(Instant.now());
        }
        user.setModifiedTime(Instant.now());
        logger.info("save user to db : {}",
                user);
        return repository.save(user);
    }

    public User updateUser(User user){
        return saveUser(user);
    }

    public void deleteUser(String id) {
        logger.info("soft delete user by {}",id);
        repository.deleteById(id);
    }

    public void enableUser(String id){
        logger.info("enable user by {}",id);
        repository.enableById(id);
    }

    public void disableUser(String id){
        logger.info("disable user by {}",id);
        repository.disableById(id);
    }

    public UserData getUserData(String id){
        User user = getUser(id);
        return getUserData(user);
    }

    private UserData getUserData(User user) {
        if(user!=null){
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
        return  null;
    }


}
