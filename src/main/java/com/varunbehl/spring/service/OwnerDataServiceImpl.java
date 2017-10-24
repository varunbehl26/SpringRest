package com.varunbehl.spring.service;

import com.varunbehl.spring.model.Owner;
import com.varunbehl.spring.persistence.OwnerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("myDataService")
public class OwnerDataServiceImpl implements OwnerDataService {

    @Autowired
    private OwnerMapper ownerMapper;

    @Override
    public List<Owner> listAllGymOwners() {
        return ownerMapper.listAllGymOwners();
    }


    @Override
    public Owner findOwnerById(long id) {
        return ownerMapper.findOwnerById(id);
    }

    @Override
    public boolean saveOwner(Owner myData) {
        ownerMapper.saveOwner(myData);
        return true;
    }


    @Override
    public void updateMyData(Owner currentMyData) {
        // TODO Auto-generated method stub

    }


    @Override
    public boolean isMyDataExist(Owner myData) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public int deleteOwnerById(long id) {
        return ownerMapper.deleteOwnwer(id);
    }

}
