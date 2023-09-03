package com.glabs.membershipregister.service.impl;

import com.glabs.membershipregister.Entity.UserEntity;
import com.glabs.membershipregister.adapter.Transformer;
import com.glabs.membershipregister.models.User;
import com.glabs.membershipregister.repository.MembershipMongoRepository;
import com.glabs.membershipregister.service.RegisterService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class RegisterServiceImpl implements RegisterService {

    private final MembershipMongoRepository membershipMongoRepository;
    private final Transformer<User, UserEntity> userToUserEntityTransformer;
    @Override
    public String registerUser(User user) {
        UserEntity userEntity = userToUserEntityTransformer.transform(user);
        membershipMongoRepository.save(userEntity);
        return userEntity.getMembershipId();
    }

    @Override
    public UserEntity getUserById(String membershipId) {
        return membershipMongoRepository.getUserById(membershipId);
    }

    @Override
    public List<UserEntity> getAllUsers() {
        return membershipMongoRepository.getAllUsers();
    }

    @Override
    public Object updateUserById(User user) {
        UserEntity userEntity = userToUserEntityTransformer.transform(user);
        return membershipMongoRepository.save(userEntity);
    }

    @Override
    public Object deleteUserById(String membershipId) {
        return membershipMongoRepository.deleteById(membershipId);
    }
}
