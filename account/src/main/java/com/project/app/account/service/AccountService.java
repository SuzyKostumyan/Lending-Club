/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.app.account.service;

import com.project.app.account.model.Account;
import com.project.app.account.repository.AccountRepository;
import com.project.app.account.utils.PasswordHash;
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
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    public boolean isLogin = false;

    private Account findAccount = new Account();

    public Optional<Account> registration(Account account) {
        log.info("Users registration");
        account.setId(System.currentTimeMillis());
        if (!accountRepository.findByEmail(account.getEmail()).isPresent()) {

            if (account.getPassword().isEmpty()) {
                return Optional.empty();
            }

            account.setPassword(PasswordHash.hashPassword(account.getPassword()));
            //  account.setAccountType(AccountType.BORROWER.getValue());
            Account registration = accountRepository.save(account);
            return Optional.ofNullable(registration);
        }

        log.info("This email already registered");
        return Optional.empty();
    }

    public Optional<?> login(String email, String password) {
        log.info("Users login");

        if (email == null || password == null) {
            log.info("Pls give email or password");
            return Optional.empty();
        }
        if (isLogin == true) {
            log.info("You are already logged in");
            return Optional.empty();
        }
        findAccount = accountRepository.findByEmailAndPassword(email, PasswordHash.hashPassword(password));

        if (findAccount == null) {
            log.info("Try again or sign up");
            return Optional.empty();
        }

        isLogin = true;
        log.info("User logged in the system");
        return Optional.ofNullable(findAccount);

    }

    public boolean logout() {

        if (isLogin == false) {
            log.info("You are already logged out from system or not even logged in");
            return false;
        }

        log.info("logout");
        isLogin = false;
        log.info("Success logout");
        return true;
    }

    public Account update(Account account) {
        log.info("for changing fields");

//        user.setRole(RoleType.REGULAR.getValue());
        if (account.getId() != null) {
            return accountRepository.save(account);
        } else {
            log.error("For update please provide Id");
            return new Account();
        }
    }

    public Iterable<Account> findAll() {
        return accountRepository.findAll();
    }

    public void deleteAll() {
        accountRepository.deleteAll();
    }

//    public AccountType[] getAccountTypes() {
//
//        return AccountType.values();
//    }
}
