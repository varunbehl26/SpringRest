package com.varunbehl.spring.service;

import com.varunbehl.spring.model.User;

import java.util.List;

public interface UserDataService {
    List<User> getAllUsers();

    List<User> getUsersByGymId(String id);

    int saveUserData(User myData);

    User getUserByEmail(String email);
}
