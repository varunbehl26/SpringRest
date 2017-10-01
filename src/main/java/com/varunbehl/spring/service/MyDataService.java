package com.varunbehl.spring.service;

import com.varunbehl.spring.model.Owner;

import java.util.List;


public interface MyDataService {

    List<Owner> getAllData();

    boolean saveData(Owner myData);

    boolean deleteData(Owner myData);

    void deleteAllMyDatas();

    void deleteMyDataById(long id);

    Owner findById(String id);

    void updateMyData(Owner currentMyData);

    void saveMyData(Owner myData);

    boolean isMyDataExist(Owner myData);
}
