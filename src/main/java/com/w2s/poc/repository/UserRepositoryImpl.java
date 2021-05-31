package com.w2s.poc.repository;

import com.mongodb.client.result.UpdateResult;
import com.w2s.poc.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import java.time.Instant;

@Repository
@Qualifier("userRepositoryImpl")
public class UserRepositoryImpl implements UserRepository{

    @Autowired
    private MongoTemplate mongoTemplate;

    public User findById(String id){
        return mongoTemplate.findById(id,User.class);
    }
    public User save(User user){
        return mongoTemplate.save(user);
    }
    public long enableById(String id){
        Query query = new Query(Criteria.where("_id").is(id));
        Update update = new Update();
        update.set("enabled",true);
        update.set("modifiedTime", Instant.now());
        UpdateResult result = mongoTemplate.updateFirst(query,update,User.class);
        return result.getModifiedCount();
    }
    public long disableById(String id){
        Query query = new Query(Criteria.where("_id").is(id));
        Update update = new Update();
        update.set("enabled",false);
        update.set("modifiedTime", Instant.now());
        UpdateResult result = mongoTemplate.updateFirst(query,update,User.class);
        return result.getModifiedCount();
    }
    public long deleteById(String id){
        Query query = new Query(Criteria.where("_id").is(id));
        Update update = new Update();
        update.set("enabled",false);
        update.set("deleted",true);
        update.set("locked",true);
        update.set("modifiedTime", Instant.now());
        UpdateResult result = mongoTemplate.updateFirst(query,update,User.class);
        return result.getModifiedCount();
    }

}
