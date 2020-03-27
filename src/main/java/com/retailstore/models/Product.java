/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.retailstore.models;

import java.io.Serializable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

/**
 *
 * @author Erick Ngari
 */
public class Product implements Serializable {

    private Integer id;
    private String productName;
    private String description;
    private Integer quantity;
    private Double itemCost;

    public enum Categories {
        Grocery, Electronics, Stationery, Other;
    }
    @Enumerated(EnumType.STRING)
    private Categories category;

    public Product(Integer id) {
        this.id = id;
    }

    public Product(Integer id, String productName, String description, Integer quantity, Double itemCost, Categories category) {
        this.id = id;
        this.productName = productName;
        this.description = description;
        this.quantity = quantity;
        this.itemCost = itemCost;
        this.category = category;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getItemCost() {
        return itemCost;
    }

    public void setItemCost(Double itemCost) {
        this.itemCost = itemCost;
    }

    public Categories getCategory() {
        return category;
    }

    public void setCategory(Categories category) {
        this.category = category;
    }

}
