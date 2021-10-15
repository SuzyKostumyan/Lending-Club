/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.app.profile.service;

import com.project.app.profile.model.InvestorProfile;
import com.project.app.profile.repository.InvestorRepository;
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
public class InvestorService {

    @Autowired
    InvestorRepository investorRepository;

    public Optional<InvestorProfile> create(InvestorProfile profile) {
        profile.setId(System.currentTimeMillis());

        InvestorProfile investorProfile = investorRepository.save(profile);

        return Optional.ofNullable(investorProfile);
    }

    public InvestorProfile update(InvestorProfile profile) {
        log.info("for changing fields");

        if (profile.getId() != null) {
            return investorRepository.save(profile);
        } else {
            log.error("For update please provide Id");
            return new InvestorProfile();
        }
    }

    public Iterable<InvestorProfile> findAll() {
        return investorRepository.findAll();
    }

    public void deleteAll() {
        investorRepository.deleteAll();
    }

}
