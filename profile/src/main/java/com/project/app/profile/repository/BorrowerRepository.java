/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.app.profile.repository;

import com.project.app.profile.model.BorrowerProfile;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author suzy
 */
@Repository
public interface BorrowerRepository extends JpaRepository<BorrowerProfile, Long> {
    
        Optional<BorrowerProfile> findByAccountId(Long accountId);

}
