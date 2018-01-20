package com.varunbehl.spring.service;

import com.varunbehl.spring.model.Gym;
import com.varunbehl.spring.persistence.GymDataMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("gymDataService")
public class GymDataServiceImpl implements GymDataService {

    @Autowired
    private GymDataMapper gymDataMapper;

    @Override
    public List<Gym> listAllGyms() {
        return gymDataMapper.listAllGyms();
    }

    @Override
    public Gym findGymById(String id) {
        return gymDataMapper.findGymById(id);
    }


    public void saveGymData(Gym myData) {
        gymDataMapper.saveGymData(myData);
    }

    @Override
    public void deletegymById(long id) {
        gymDataMapper.deletegymById(id);
    }

    @Override
    public void updateGym(Gym gym) {
        gymDataMapper.updateGym(gym);

    }

}
