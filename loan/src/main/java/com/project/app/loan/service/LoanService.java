/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.app.loan.service;

import com.project.app.loan.model.Loan;
import com.project.app.loan.repository.LoanRepository;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author suzy
 */
@Service
@Slf4j
public class LoanService {
    @Autowired
    LoanRepository loanRepository;
    
    public Optional<Loan> create(Loan loan) {
        loan.setId(System.currentTimeMillis());

        Loan borrowerProfile = loanRepository.save(loan);

        return Optional.ofNullable(borrowerProfile);
    }
    
    public Iterable<Loan> findAll() {
        return loanRepository.findAll();
    }
    
}
