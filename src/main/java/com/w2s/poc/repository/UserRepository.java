package com.w2s.poc.repository;

import com.w2s.poc.model.User;


public interface UserRepository {

    public User findById(String id);

    public User save(User user);

    public long enableById(String id);

    public long disableById(String id);

    public long deleteById(String id);
}
