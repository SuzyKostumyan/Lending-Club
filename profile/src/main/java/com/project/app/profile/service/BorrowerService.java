/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.app.profile.service;

import com.project.app.profile.model.BorrowerProfile;
import com.project.app.profile.repository.BorrowerRepository;
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
public class BorrowerService {

    @Autowired
    BorrowerRepository borrowerRepository;

    public Optional<BorrowerProfile> create(BorrowerProfile profile) {
        profile.setId(System.currentTimeMillis());

        BorrowerProfile borrowerProfile = borrowerRepository.save(profile);

        return Optional.ofNullable(borrowerProfile);
    }

    public BorrowerProfile update(BorrowerProfile profile) {
        log.info("for changing fields");

        if (profile.getId() != null) {
            return borrowerRepository.save(profile);
        } else {
            log.error("For update please provide Id");
            return new BorrowerProfile();
        }
    }

    public Iterable<BorrowerProfile> findAll() {
        return borrowerRepository.findAll();
    }

    public void deleteAll() {
        borrowerRepository.deleteAll();
    }

}
