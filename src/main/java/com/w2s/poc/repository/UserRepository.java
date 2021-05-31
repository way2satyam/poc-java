package com.w2s.poc.repository;

import com.w2s.poc.model.User;


public interface UserRepository {

    User findById(String id);

    User save(User user);

    long enableById(String id);

    long disableById(String id);

    long lockById(String id);
}
