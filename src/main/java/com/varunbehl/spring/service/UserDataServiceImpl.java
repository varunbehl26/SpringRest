package com.varunbehl.spring.service;

import com.varunbehl.spring.model.User;
import com.varunbehl.spring.persistence.UserDataMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userDataService")
public class UserDataServiceImpl implements UserDataService {

    @Autowired
    private UserDataMapper userDataMapper;

    @Override
    public List<User> getAllUsers() {
        return userDataMapper.getAllUsers();
    }

    @Override
    public List<User> getUsersByGymId(String id) {
        return userDataMapper.getUsersByGymId(id);
    }

    public int saveUserData(User myData) {
        return userDataMapper.saveData(myData);
    }

    @Override
    public User getUserByEmail(String email) {
        return userDataMapper.getUserByEmail(email);
    }

}
