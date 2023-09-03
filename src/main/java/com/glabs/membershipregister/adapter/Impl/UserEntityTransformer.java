package com.glabs.membershipregister.adapter.Impl;

import com.glabs.membershipregister.Entity.UserEntity;
import com.glabs.membershipregister.adapter.Transformer;
import com.glabs.membershipregister.models.User;
import org.springframework.stereotype.Component;

@Component
public class UserEntityTransformer implements Transformer<UserEntity, User> {
    @Override
    public User transform(UserEntity userEntity) {
        User user = new User();
        user.setMembershipId(userEntity.getMembershipId());
        user.setName(userEntity.getName());
        user.setMobileNumber(userEntity.getMobileNumber());
        user.setEmail(userEntity.getEmail());
        user.setMealPlan(userEntity.getMealPlan());
        user.setApproved(userEntity.getApproved());
        user.setIsActive(userEntity.getIsActive());
        user.setChanceToApprove(userEntity.getChanceToApprove());
        return user;
    }
}
