package com.varunbehl.spring.service;

import com.varunbehl.spring.model.User;

import java.util.List;

public interface UserDataService {
    List<User> getAllData();

    User findById(String id);

    void saveUserData(User myData);

}
