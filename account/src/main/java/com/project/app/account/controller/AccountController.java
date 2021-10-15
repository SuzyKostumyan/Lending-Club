/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.app.account.controller;

import com.project.app.account.model.Account;
import com.project.app.account.model.AccountDTO;
import com.project.app.account.service.AccountService;
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
@RequestMapping("/api/v2/account")
@Slf4j
public class AccountController {

    @Autowired
    private AccountService accountService;

    @PostMapping(path = "/registration", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity registration(@RequestBody Account account) {
        
        Optional<Account> saveUser = accountService.registration(account);
        if (saveUser.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(saveUser);
        }
        return ResponseEntity.status(400).body(saveUser);
    }

    @PostMapping(path = "/login", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> loginUser(@RequestBody AccountDTO request) {

        Optional<?> loginUser = accountService.login(request.getEmail(), request.getPassword());
        if (loginUser.isPresent()) {

            return ResponseEntity.status(HttpStatus.OK).body(loginUser);
        }
        return ResponseEntity.status(400).body(loginUser);
    }

    @PostMapping(path = "/logout", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> logout() {
        boolean logoutUser = accountService.logout();
        return ResponseEntity.status(HttpStatus.OK).body(logoutUser);
    }

    @GetMapping(path = "/findAll/registered/accounts", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Account> findAll() {
        return (List<Account>) accountService.findAll();
    }

    @PutMapping(path = "/change/fields", produces = MediaType.APPLICATION_JSON_VALUE)
    public Account put(@RequestBody Account account) {
        return accountService.update(account);
    }

    @DeleteMapping("/deleteAll/accounts")
    public ResponseEntity deleteAll() {
        accountService.deleteAll();
        return ResponseEntity.status(HttpStatus.OK).body("All accounts successfullly have been deleted");
    }

}
