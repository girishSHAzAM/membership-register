package com.glabs.membershipregister.service;


import com.glabs.membershipregister.models.User;

import java.util.List;

public interface DashboardService {
    List<User> getUnapprovedMembershipRequests();
    User updateMembershipRequests(User user);
    List<User> getAllMembershipRequests();
}
