/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.app.account.repository;

import com.project.app.account.model.Account;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author suzy
 */

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

    Account findByEmailAndPassword(String email, String password);

    Optional<Account> findByEmail(String email);

}
