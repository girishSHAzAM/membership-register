package com.glabs.membershipregister.service.impl;

import com.glabs.membershipregister.Entity.UserEntity;
import com.glabs.membershipregister.adapter.Transformer;
import com.glabs.membershipregister.models.User;
import com.glabs.membershipregister.repository.MembershipMongoRepository;
import com.glabs.membershipregister.service.DashboardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class DashboardServiceImpl implements DashboardService {

    private final MembershipMongoRepository membershipMongoRepository;
    private final Transformer<UserEntity, User> userEntityToUserTransformer;
    private final Transformer<User, UserEntity> userToUserEntityTransformer;

    @Override
    public List<User> getUnapprovedMembershipRequests() {
        List<UserEntity> userEntities = membershipMongoRepository.getAllApprovalPendingUsers();
        return userEntities.parallelStream().map(userEntityToUserTransformer::transform).collect(Collectors.toList());
    }

    @Override
    public User updateMembershipRequests(User user) {
        UserEntity userEntity = userToUserEntityTransformer.transform(user);
        membershipMongoRepository.save(userEntity);
        return user;
    }

    @Override
    public List<User> getAllMembershipRequests() {
        List<UserEntity> userEntities = membershipMongoRepository.getAllUsers();
        return userEntities.parallelStream().map(userEntityToUserTransformer :: transform).collect(Collectors.toList());
    }
}
