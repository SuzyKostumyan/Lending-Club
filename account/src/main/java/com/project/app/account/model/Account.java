/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.app.account.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author suzy
 */


@Table(name = "account", schema = "public")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Account implements Serializable {

    private static final long serialVersionUID = 1L;

     public enum AccountType {
        borrower,
        investor
    }
     
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private String password;
    @Column(name = "phone")
    private Integer phone;
    @Column(name = "zoom")
    private String zoom;
    @Column(name = "address")
    private String address;
    @Column(name = "account_type")
    private String accountType;
    
 //   @OneToOne(mappedBy = "account", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
 //   private BorrowerProfile borrowerProfile;
    
}
