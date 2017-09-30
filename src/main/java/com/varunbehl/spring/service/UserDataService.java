package com.varunbehl.spring.service;

import java.util.List;

import com.varunbehl.spring.model.Owner;
import com.varunbehl.spring.model.User;

public interface UserDataService {
	public List<User> getAllData();

	public User findById(String id);

	public void saveUserData(User myData);

}
