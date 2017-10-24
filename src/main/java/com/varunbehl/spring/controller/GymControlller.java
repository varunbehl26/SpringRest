package com.varunbehl.spring.controller;

import com.varunbehl.spring.model.Gym;
import com.varunbehl.spring.service.GymDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
public class GymControlller {

    @Autowired
    private GymDataService gymDataService;


    @RequestMapping(value = "/Gym/", method = RequestMethod.GET)
    public ResponseEntity<List<Gym>> listAllGyms() {
        List<Gym> gymList = gymDataService.listAllGyms();
        if (gymList.isEmpty()) {
            return new ResponseEntity<List<Gym>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Gym>>(gymList, HttpStatus.OK);
    }

    @RequestMapping(value = "/Gym/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Gym> findGymById(@PathVariable("id") String id) {
        System.out.println("Fetching gym with id " + id);
        Gym gym = gymDataService.findGymById(id);
        if (gym == null) {
            return new ResponseEntity<Gym>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Gym>(gym, HttpStatus.OK);
    }


    @RequestMapping(value = "/Gym/", method = RequestMethod.POST)
    public ResponseEntity<Integer> createNewGym(@RequestBody Gym gym, UriComponentsBuilder ucBuilder) {

//		if (gymDataService.isgymExist(gym)) {
//			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
//		}

        gymDataService.saveGymData(gym);

        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<Integer>(1, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/Gym/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Gym> updategym(@PathVariable("id") long id,
                                         @RequestBody Gym gym) {
        System.out.println("Updating gym " + id);

        Gym currentgym = gymDataService.findGymById(id + "");

        if (currentgym == null) {
            System.out.println("gym with id " + id + " not found");
            return new ResponseEntity<Gym>(HttpStatus.NOT_FOUND);
        }

        gymDataService.updateGym(currentgym);
        return new ResponseEntity<Gym>(currentgym, HttpStatus.OK);
    }


    @RequestMapping(value = "/gym/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Gym> deletegym(@PathVariable("id") long id) {
        System.out.println("Fetching & Deleting gym with id " + id);

        Gym gym = gymDataService.findGymById(id + "");
        if (gym == null) {
            System.out.println("Unable to delete. gym with id " + id + " not found");
            return new ResponseEntity<Gym>(HttpStatus.NOT_FOUND);
        }

        gymDataService.deletegymById(id);
        return new ResponseEntity<Gym>(HttpStatus.NO_CONTENT);
    }


}
