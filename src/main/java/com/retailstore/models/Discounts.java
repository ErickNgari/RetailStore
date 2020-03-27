/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.retailstore.models;

import java.io.Serializable;

/**
 *
 * @author Erick Ngari
 */
public class Discounts implements Serializable {

    private Integer id;
    private String discountType;
    private Double discountValue;

    public Discounts(Integer id, String discountType, Double discountValue) {
        this.id = id;
        this.discountType = discountType;
        this.discountValue = discountValue;
    }    

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDiscountType() {
        return discountType;
    }

    public void setDiscountType(String discountType) {
        this.discountType = discountType;
    }

    public Double getDiscountValue() {
        return discountValue;
    }

    public void setDiscountValue(Double discountValue) {
        this.discountValue = discountValue;
    }

}
