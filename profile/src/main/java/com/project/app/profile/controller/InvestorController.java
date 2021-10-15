/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.app.profile.controller;

import com.project.app.profile.model.InvestorProfile;
import com.project.app.profile.service.InvestorService;
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

/**
 *
 * @author suzy
 */
@RestController
@RequestMapping("/api/investor/profile")
@Slf4j
public class InvestorController {
    @Autowired
    InvestorService investorService;
    
    @PostMapping(path = "/create", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity registration(@RequestBody InvestorProfile profile) {
        
        Optional<InvestorProfile> borrower = investorService.create(profile);
        if (borrower.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(borrower);
        }
        return ResponseEntity.status(400).body(borrower);
    }
    
    @PutMapping(path = "/change/fields", produces = MediaType.APPLICATION_JSON_VALUE)
    public InvestorProfile put(@RequestBody InvestorProfile profile) {
        return investorService.update(profile);
    }
    
    @GetMapping(path = "/findAll/created/profiles", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<InvestorProfile> findAll() {
        return (List<InvestorProfile>) investorService.findAll();
    }

  
    @DeleteMapping("/deleteAll/profiles")
    public ResponseEntity deleteAll() {
        investorService.deleteAll();
        return ResponseEntity.status(HttpStatus.OK).body("All accounts successfullly have been deleted");
    }
    
    
}