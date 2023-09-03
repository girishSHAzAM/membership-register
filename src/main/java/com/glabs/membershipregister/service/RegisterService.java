package com.glabs.membershipregister.service;


import com.glabs.membershipregister.models.User;

public interface RegisterService {
    String registerUser(User user);
    Object getUserById(String membershipId);
    Object getAllUsers();
    Object updateUserById(User user);
    Object deleteUserById(String membershipId);
}
