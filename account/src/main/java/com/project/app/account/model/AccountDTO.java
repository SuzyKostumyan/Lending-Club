/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.app.account.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author suzy
 */


//@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class AccountDTO {

    private String email;
    private String password;
    
}
