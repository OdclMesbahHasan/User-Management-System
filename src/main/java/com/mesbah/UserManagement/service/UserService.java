package com.mesbah.UserManagement.service;

import com.mesbah.UserManagement.model.User;

import java.util.List;

public interface UserService {
    User saveUser(User user);
    List<User> getAllUsers();
    User getUserById(Long id);
    boolean deleteUser(Long id);
    User updateUser(Long id, User user);
}
