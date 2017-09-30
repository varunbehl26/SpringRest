package com.varunbehl.spring.service;

import java.util.List;

import com.varunbehl.spring.model.Owner;


public interface MyDataService {

	public List<Owner> getAllData();

	public boolean saveData(Owner myData);

	public boolean deleteData(Owner myData);

	public void deleteAllMyDatas();

	public void deleteMyDataById(long id);

	public Owner findById(String id);

	public void updateMyData(Owner currentMyData);

	public void saveMyData(Owner myData);

	public boolean isMyDataExist(Owner myData);
}
