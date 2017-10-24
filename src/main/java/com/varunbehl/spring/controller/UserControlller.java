package com.varunbehl.spring.controller;

import com.varunbehl.spring.model.User;
import com.varunbehl.spring.service.UserDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
public class UserControlller {

    @Autowired
    private UserDataService userDataService;


    @RequestMapping(value = "/User/", method = RequestMethod.GET)
    public ResponseEntity<List<User>> listAllMyDatas() {
        List<User> userList = userDataService.getAllData();
        if (userList.isEmpty()) {
            return new ResponseEntity<List<User>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<User>>(userList, HttpStatus.OK);
    }


    @RequestMapping(value = "/User/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<User>> getMyData(@PathVariable("id") String id) {
        System.out.println("Fetching userList with id " + id);
        List<User> userList = userDataService.findById(id);
        if (userList == null) {
            return new ResponseEntity<List<User>>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<List<User>>(userList, HttpStatus.OK);
    }

    @RequestMapping(value = "/User/{email}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> findByEmail(@PathVariable("email") String email) {
        System.out.println("Fetching userList with id " + email);
        User user = userDataService.findByEmail(email);
        if (user == null) {
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }


    @RequestMapping(value = "/User/", method = RequestMethod.POST)
    public ResponseEntity<User> createMyData(@RequestBody User user, UriComponentsBuilder ucBuilder) {


        User userFromDb = userDataService.findByEmail(user.getUserEmail());

        if (userFromDb != null) {
            return new ResponseEntity<User>(userFromDb, HttpStatus.CONFLICT);
        }

        int id = userDataService.saveUserData(user);
        if (id == 1) userFromDb = userDataService.findByEmail(user.getUserEmail());

        if (id != 1 && user.getUserId() != null) {
            return new ResponseEntity<User>(userFromDb, HttpStatus.CREATED);
        }

        return null;
    }

    // // ---- Update a MyData ---------------------------------------------
    // @RequestMapping(value = "/MyData/{id}", method = RequestMethod.PUT)
    // public ResponseEntity<Owner> updateMyData(@PathVariable("id") long id,
    // @RequestBody Owner MyData) {
    // System.out.println("Updating MyData " + id);
    //
    // Owner currentMyData = myDataService.findById(id);
    //
    // if (currentMyData == null) {
    // System.out.println("MyData with id " + id + " not found");
    // return new ResponseEntity<Owner>(HttpStatus.NOT_FOUND);
    // }
    //
    // myDataService.updateMyData(currentMyData);
    // return new ResponseEntity<Owner>(currentMyData, HttpStatus.OK);
    // }

    // // ------------------- Delete a MyData --------------------------------------
    //
    // @RequestMapping(value = "/MyData/{id}", method = RequestMethod.DELETE)
    // public ResponseEntity<Owner> deleteMyData(@PathVariable("id") long id) {
    // System.out.println("Fetching & Deleting MyData with id " + id);
    //
    // Owner MyData = myDataService.findById(id);
    // if (MyData == null) {
    // System.out.println("Unable to delete. MyData with id " + id + " not found");
    // return new ResponseEntity<Owner>(HttpStatus.NOT_FOUND);
    // }
    //
    // myDataService.deleteMyDataById(id);
    // return new ResponseEntity<Owner>(HttpStatus.NO_CONTENT);
    // }
    //
    // // ------------------- Delete All MyDatas -----------------------
    //
    // @RequestMapping(value = "/MyData/", method = RequestMethod.DELETE)
    // public ResponseEntity<Owner> deleteAllMyDatas() {
    // System.out.println("Deleting All MyDatas");
    //
    // myDataService.deleteAllMyDatas();
    // return new ResponseEntity<Owner>(HttpStatus.NO_CONTENT);
    // }

}
