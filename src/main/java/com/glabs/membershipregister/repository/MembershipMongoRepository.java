package com.glabs.membershipregister.repository;

import com.glabs.membershipregister.Entity.UserEntity;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.glabs.membershipregister.constants.Constants.MEMBERSHIP_REGISTER_COLLECTION;

@Slf4j
@Repository
@RequiredArgsConstructor
public class MembershipMongoRepository{
    private final MongoTemplate mongoTemplate;

    public UserEntity save(UserEntity user){
        this.mongoTemplate.save(user);
        return user;
    }

    public UserEntity getUserById(String membershipId){
        return this.mongoTemplate.findById(membershipId, UserEntity.class);
    }

    public List<UserEntity> getAllUsers(){
        Query query = new Query();
        query.with(Sort.by(Sort.Direction.DESC, "createdAt"));
        return this.mongoTemplate.find(query, UserEntity.class, MEMBERSHIP_REGISTER_COLLECTION);
    }

    public List<UserEntity> getAllApprovalPendingUsers(){
        Query query = new Query();
        query.addCriteria(Criteria.where("chanceToApprove").is(false));
        return this.mongoTemplate.find(query, UserEntity.class, MEMBERSHIP_REGISTER_COLLECTION);
    }

    public UserEntity deleteById(String membershipId){
        Query query = new Query();
        query.addCriteria(Criteria.where("membershipId").is(membershipId));
        return this.mongoTemplate.findAndRemove(query, UserEntity.class, MEMBERSHIP_REGISTER_COLLECTION);
    }
}
