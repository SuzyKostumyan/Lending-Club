/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.app.profile.controller;

import com.project.app.profile.model.BorrowerProfile;
import com.project.app.profile.service.BorrowerService;
import java.util.List;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author suzy
 */
@RestController
@RequestMapping("/api/borrower/profile")
@Slf4j
public class BorrowerController {

    @Autowired
    BorrowerService borrowerService;
    @Autowired
    RestTemplate restTemplate;

    @PostMapping(path = "/create", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity registration(@RequestBody BorrowerProfile profile) {

        Optional<BorrowerProfile> borrower = borrowerService.create(profile);
        if (borrower.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(borrower);
        }
        return ResponseEntity.status(400).body(borrower);
    }

    @PutMapping(path = "/change/fields", produces = MediaType.APPLICATION_JSON_VALUE)
    public BorrowerProfile put(@RequestBody BorrowerProfile profile) {
        return borrowerService.update(profile);
    }

    @GetMapping(path = "/findAll/created/profiles", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<BorrowerProfile> findAll() {
        return (List<BorrowerProfile>) borrowerService.findAll();
    }

    @DeleteMapping("/deleteAll/profiles")
    public ResponseEntity deleteAll() {
        borrowerService.deleteAll();
        return ResponseEntity.status(HttpStatus.OK).body("All accounts successfullly have been deleted");
    }

//    @GetMapping(path = "/dataFromAccount", produces = MediaType.APPLICATION_JSON_VALUE)
//    ResponseEntity dataFromAcocunt() {
//        ResponseEntity<String> dataOfAccount = restTemplate.getForEntity("http://localhost:4040/api/v2/account/findAll/registered/accounts", String.class);
//        return ResponseEntity.status(HttpStatus.OK).body(dataOfAccount.getBody());
//    }
    
}
