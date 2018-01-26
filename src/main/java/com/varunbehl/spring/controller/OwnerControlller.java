package com.varunbehl.spring.controller;

import com.varunbehl.spring.model.MasterResponse;
import com.varunbehl.spring.model.Owner;
import com.varunbehl.spring.service.OwnerDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
class OwnerControlller {

    @Autowired
    private OwnerDataService ownerDataService;


    @RequestMapping(value = "/Owner/", method = RequestMethod.GET)
    public ResponseEntity<MasterResponse> listAllGymOwners() {
        List<Owner> ownerList = ownerDataService.listAllGymOwners();
        if (ownerList.isEmpty()) {
            return new ResponseEntity<MasterResponse>(HttpStatus.NO_CONTENT);
        }
        MasterResponse masterResponse = new MasterResponse("", true, ownerList);
        return new ResponseEntity<MasterResponse>(masterResponse, HttpStatus.OK);
    }


    @RequestMapping(value = "/Owner/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<MasterResponse> findOwnerById(@PathVariable("id") long id) {
        Owner owner = ownerDataService.findOwnerById(id);
        if (owner == null) {
            System.out.println("owner with id " + id + " not found");
            return new ResponseEntity<MasterResponse>(HttpStatus.NOT_FOUND);
        }
        MasterResponse masterResponse = new MasterResponse("", true, owner);
        return new ResponseEntity<MasterResponse>(masterResponse, HttpStatus.OK);
    }


    @RequestMapping(value = "/Owner/", method = RequestMethod.POST)
    public ResponseEntity<Void> createOwner(@RequestBody Owner Owner, UriComponentsBuilder ucBuilder) {

//        if (ownerDataService.isOwnerExist(Owner)) {
//            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
//        }

        ownerDataService.saveOwner(Owner);

        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/Owner/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Owner> updateOwner(@PathVariable("id") long id, @RequestBody Owner Owner) {
        System.out.println("Updating Owner " + id);

        Owner currentOwner = ownerDataService.findOwnerById(id);

        if (currentOwner == null) {
            System.out.println("Owner with id " + id + " not found");
            return new ResponseEntity<Owner>(HttpStatus.NOT_FOUND);
        }

//		ownerDataService.updateOwner(currentOwner);
        return new ResponseEntity<Owner>(currentOwner, HttpStatus.OK);
    }


    @RequestMapping(value = "/Owner/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Owner> deleteOwner(@PathVariable("id") long id) {
        System.out.println("Fetching & Deleting Owner with id " + id);

        Owner Owner = ownerDataService.findOwnerById(id);
        if (Owner == null) {
            System.out.println("Unable to delete. Owner with id " + id + " not found");
            return new ResponseEntity<Owner>(HttpStatus.NOT_FOUND);
        }

        ownerDataService.deleteOwnerById(id);
        return new ResponseEntity<Owner>(HttpStatus.NO_CONTENT);
    }


}
