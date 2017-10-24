package com.varunbehl.spring.service;

import com.varunbehl.spring.model.User;

import java.util.List;

public interface UserDataService {
    List<User> getAllData();

    List<User> findById(String id);

    int saveUserData(User myData);

    User findByEmail(String email);
}
