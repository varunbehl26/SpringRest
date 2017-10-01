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
    public List<User> getAllData() {
        return userDataMapper.getAllData();
    }

    @Override
    public User findById(String id) {
        return userDataMapper.findById(id);
    }

    public void saveUserData(User myData) {
        userDataMapper.saveData(myData);
    }

}
