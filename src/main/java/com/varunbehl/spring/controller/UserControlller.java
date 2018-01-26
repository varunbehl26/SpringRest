package com.varunbehl.spring.controller;

import com.varunbehl.spring.model.MasterResponse;
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
    public ResponseEntity<MasterResponse> getAllUsers() {
        List<User> userList = userDataService.getAllUsers();
        if (userList.isEmpty()) {
            return new ResponseEntity<MasterResponse>(HttpStatus.NO_CONTENT);
        }
        MasterResponse masterResponse = new MasterResponse("", true, userList);
        return new ResponseEntity<MasterResponse>(masterResponse, HttpStatus.OK);
    }

    @RequestMapping(value = "/User/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<MasterResponse> getUsersByGymId(@PathVariable("id") String id) {
        List<User> userList = userDataService.getUsersByGymId(id);
        if (userList == null) {
            return new ResponseEntity<MasterResponse>(HttpStatus.NOT_FOUND);
        }
        MasterResponse masterResponse = new MasterResponse("", true, userList);
        return new ResponseEntity<MasterResponse>(masterResponse, HttpStatus.OK);
    }

//    @RequestMapping(value = "/User/{email}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<MasterResponse> getUserByEmail(@PathVariable("email") String email) {
//        User user = userDataService.getUserByEmail(email);
//        if (user == null) {
//            return new ResponseEntity<MasterResponse>(HttpStatus.NOT_FOUND);
//        }
//        MasterResponse masterResponse = new MasterResponse("", true, user);
//        return new ResponseEntity<MasterResponse>(masterResponse, HttpStatus.OK);
//    }

    @RequestMapping(value = "/User/", method = RequestMethod.POST)
    public ResponseEntity<User> createMyData(@RequestBody User user, UriComponentsBuilder ucBuilder) {
        User userFromDb = userDataService.getUserByEmail(user.getUserEmail());
        if (userFromDb != null) {
            return new ResponseEntity<User>(userFromDb, HttpStatus.CONFLICT);
        }
        int id = userDataService.saveUserData(user);
        if (id == 1) userFromDb = userDataService.getUserByEmail(user.getUserEmail());
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
    // Owner currentMyData = myDataService.getUsersByGymId(id);
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
    // Owner MyData = myDataService.getUsersByGymId(id);
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
