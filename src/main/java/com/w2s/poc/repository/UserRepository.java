package com.w2s.poc.repository;

import com.mongodb.client.result.UpdateResult;
import com.w2s.poc.bean.User;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;

import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import java.time.Instant;
import java.util.List;
import java.util.Optional;


public interface UserRepository {

    public User findById(String id);

    public User save(User user);

    public long enableById(String id);

    public long disableById(String id);

    public long deleteById(String id);
}
