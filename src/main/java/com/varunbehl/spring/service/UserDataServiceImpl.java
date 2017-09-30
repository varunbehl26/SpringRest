package com.varunbehl.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.varunbehl.spring.model.User;
import com.varunbehl.spring.persistence.UserDataMapper;

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
