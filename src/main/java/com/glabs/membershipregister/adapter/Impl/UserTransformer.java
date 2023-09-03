package com.glabs.membershipregister.adapter.Impl;

import com.glabs.membershipregister.Entity.UserEntity;
import com.glabs.membershipregister.adapter.Transformer;
import com.glabs.membershipregister.models.User;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.UUID;

@Component
public class UserTransformer implements Transformer<User, UserEntity> {

    @Override
    public UserEntity transform(User user) {
        UserEntity entity = new UserEntity();
        entity.setMembershipId(Objects.isNull(user.getMembershipId()) ? UUID.randomUUID().toString() : user.getMembershipId());
        entity.setName(user.getName());
        entity.setEmail(user.getEmail());
        entity.setMobileNumber(user.getMobileNumber());
        entity.setMealPlan(user.getMealPlan());
        entity.setStartDate(user.getStartDate());
        entity.setApproved(Objects.nonNull(user.getApproved()) ? user.getApproved() : false);
        entity.setIsActive(Objects.nonNull(user.getIsActive()) ? user.getIsActive() : false);
        entity.setChanceToApprove(Objects.nonNull(user.getChanceToApprove()) ? user.getChanceToApprove() : false);
        entity.setCreatedAt(Objects.nonNull(user.getCreatedAt()) ? user.getCreatedAt() : System.currentTimeMillis());
        entity.setModifiedAt(System.currentTimeMillis());
        return entity;
    }
}
