package com.varunbehl.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.varunbehl.spring.model.Owner;
import com.varunbehl.spring.persistence.MyDataMapper;

@Service("myDataService")
public class MyDataServiceImpl implements MyDataService {

	@Autowired
	private MyDataMapper myDataMapper;

	@Override
	public List<Owner> getAllData() {
		return myDataMapper.getAllData();
	}

	@Override
	public boolean saveData(Owner myData) {
		myDataMapper.saveData(myData);
		return true;
	}

	@Override
	public boolean deleteData(Owner myData) {
		return myDataMapper.deleteData(myData) > 0;
	}

	@Override
	public void deleteAllMyDatas() {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteMyDataById(long id) {
		// TODO Auto-generated method stub

	}

	@Override
	public Owner findById(String id) {
		return myDataMapper.findById(id);
	}

	@Override
	public void updateMyData(Owner currentMyData) {
		// TODO Auto-generated method stub

	}

	@Override
	public void saveMyData(Owner myData) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isMyDataExist(Owner myData) {
		// TODO Auto-generated method stub
		return false;
	}

}
