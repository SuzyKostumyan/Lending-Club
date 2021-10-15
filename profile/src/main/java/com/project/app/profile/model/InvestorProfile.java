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

@Table(name = "investor_profile", schema = "public")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class InvestorProfile implements Serializable {
    
    private static final long serialVersionUID = 2L;
     
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    
    @Column(name = "invest_amount")
    private Long investAmount;
    
    @Column(name = "borrower_incomeFrom")
    private Long borrowerIncomeFrom;
    
    @Column(name = "borrower_incomeTo")
    private Long borrowerIncomeTo;
    
    @Column(name = "ready_invest")
    private boolean readyInvest;
    
    @Column(name = "organization_id")
    private Long organizationId;

}
