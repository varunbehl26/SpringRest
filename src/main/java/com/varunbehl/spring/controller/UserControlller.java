package com.varunbehl.spring.controller;

import com.varunbehl.spring.model.User;
import com.varunbehl.spring.service.UserDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
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

    // ----------Retrieve All MyDatas-----------------------

    @RequestMapping(value = "/User/", method = RequestMethod.GET)
    public ResponseEntity<List<User>> listAllMyDatas() {
        List<User> MyDatas = userDataService.getAllData();
        if (MyDatas.isEmpty()) {
            return new ResponseEntity<List<User>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<User>>(MyDatas, HttpStatus.OK);
    }

    // -----Retrieve Single MyData-----------------------------

    @RequestMapping(value = "/User/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> getMyData(@PathVariable("id") String id) {
        System.out.println("Fetching MyData with id " + id);
        User MyData = userDataService.findById(id);
        if (MyData == null) {
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<User>(MyData, HttpStatus.OK);
    }

    // --------Create a MyData-------------------------------------

    @RequestMapping(value = "/User/", method = RequestMethod.POST)
    public ResponseEntity<Void> createMyData(@RequestBody User MyData, UriComponentsBuilder ucBuilder) {

//		if (userDataService.isMyDataExist(MyData)) {
//			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
//		}

        userDataService.saveUserData(MyData);

        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
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
