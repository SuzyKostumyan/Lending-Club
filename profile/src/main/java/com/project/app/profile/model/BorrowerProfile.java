/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.app.profile.model;

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
@Table(name = "borrower_profile", schema = "public")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class BorrowerProfile implements Serializable {

    private static final long serialVersionUID = 3L;

    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    
    @Column(name = "account_id")
    private Long accountId;

    @Column(name = "gender")
    private String gender;

    @Column(name = "address")
    private String address;

    @Column(name = "income")
    private Long income;

    @Column(name = "additional_income")
    private boolean additionalIncome;

}
