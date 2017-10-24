package com.varunbehl.spring.service;

import com.varunbehl.spring.model.Gym;

import java.util.List;

public interface GymDataService {
    List<Gym> listAllGyms();

    Gym findGymById(String id);

    void saveGymData(Gym myData);

    int deletegymById(long id);

    void updateGym(Gym gym);
}

