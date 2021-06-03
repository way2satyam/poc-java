package com.w2s.poc.service;

import com.w2s.poc.dto.UserData;
import com.w2s.poc.model.User;


public interface UserService {


    User getUser(String id);

    User saveUser(User user);

    User updateUser(User user);

    void enableUser(String id);

    void lockById(String id);

    void disableUser(String id);

    UserData getUserData(String id);

    User updateUserData(UserData user);


}
