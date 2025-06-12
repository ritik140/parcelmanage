package com.parcel.Parcel_manage.service;

import com.parcel.Parcel_manage.model.User;

import java.util.List;

public interface UserService {
    User createUser(User user);
    User getUserById(Long id);
    List<User> getAllUsers();
    User login(String username, String password);
}
