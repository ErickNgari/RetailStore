/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.retailstore.models;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Erick Ngari
 */
public class User implements Serializable{

    private Integer id;
    private String firstName;
    private String surName;
    private String email;
    private Boolean isEmployee;
    private Boolean isAffiliate;
    private Date dateRegistered;

    public User(Integer id) {
        this.id = id;
    }

    public User(Integer id, String firstName, String surName, String email, Boolean isEmployee, Boolean isAffiliate, Date dateRegistered) {
        this.id = id;
        this.firstName = firstName;
        this.surName = surName;
        this.email = email;
        this.isEmployee = isEmployee;
        this.isAffiliate = isAffiliate;
        this.dateRegistered = dateRegistered;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getIsEmployee() {
        return isEmployee;
    }

    public void setIsEmployee(Boolean isEmployee) {
        this.isEmployee = isEmployee;
    }

    public Boolean getIsAffiliate() {
        return isAffiliate;
    }

    public void setIsAffiliate(Boolean isAffiliate) {
        this.isAffiliate = isAffiliate;
    }

    public Date getDateRegistered() {
        return dateRegistered;
    }

    public void setDateRegistered(Date dateRegistered) {
        this.dateRegistered = dateRegistered;
    }

}
