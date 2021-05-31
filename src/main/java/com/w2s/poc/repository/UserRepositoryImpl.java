package com.w2s.poc.repository;

import com.mongodb.client.result.UpdateResult;
import com.w2s.poc.model.User;
import lombok.RequiredArgsConstructor;
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
@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepository{

    @Autowired
    private MongoTemplate mongoTemplate;

    public User findById(String id){
        Criteria criteria = Criteria.where("_id").is(id)
                .and("enabled").is(true)
                .and("locked").is(false);

        Query query = new Query(criteria);
        return mongoTemplate.findOne(query, User.class);
    }
    public User save(User user){
        return mongoTemplate.save(user);
    }

    public long enableById(String id) {
        Query query = new Query(Criteria.where("_id").is(id));
        Update update = new Update();
        update.set("enabled", true);
        update.set("modifiedTime", Instant.now());
        UpdateResult result = mongoTemplate.updateFirst(query, update, User.class);
        return result.getModifiedCount();
    }

    public long disableById(String id) {
        Query query = new Query(Criteria.where("_id").is(id));
        Update update = new Update();
        update.set("enabled", false);
        update.set("modifiedTime", Instant.now());
        UpdateResult result = mongoTemplate.updateFirst(query, update, User.class);
        return result.getModifiedCount();
    }

    public long lockById(String id) {
        Query query = new Query(Criteria.where("_id").is(id));
        Update update = new Update();
        update.set("enabled", false);
        update.set("locked", true);
        update.set("modifiedTime", Instant.now());
        UpdateResult result = mongoTemplate.updateFirst(query, update, User.class);
        return result.getModifiedCount();
    }

}
