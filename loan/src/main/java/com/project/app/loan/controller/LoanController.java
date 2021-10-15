/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.app.loan.controller;

import com.project.app.loan.model.Loan;
import com.project.app.loan.service.LoanService;
import java.util.List;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author suzy
 */
@RestController
@RequestMapping("/api/loan")
@Slf4j
public class LoanController {

    @Autowired
    LoanService loanService;
    
    @PostMapping(path = "/create", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity registration(@RequestBody Loan loan) {

        Optional<Loan> loanForBorrower = loanService.create(loan);
        if (loanForBorrower.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(loanForBorrower);
        }
        return ResponseEntity.status(400).body(loanForBorrower);
    }
    
    
     @GetMapping(path = "/findAll/loans", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Loan> findAll() {
        return (List<Loan>) loanService.findAll();
    }

}
