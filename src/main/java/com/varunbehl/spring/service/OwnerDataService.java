package com.varunbehl.spring.service;

import com.varunbehl.spring.model.Owner;

import java.util.List;


public interface OwnerDataService {

    List<Owner> listAllGymOwners();

    void saveOwner(Owner myData);


    Owner findOwnerById(long id);

    void updateMyData(Owner currentMyData);

    boolean isMyDataExist(Owner myData);

    void deleteOwnerById(long id);
}
