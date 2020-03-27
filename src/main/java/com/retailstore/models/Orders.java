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
public class Orders implements Serializable {

    private Integer id;
    private User userId;
    private Product productId;
    private Integer quantity;
    private Discounts discount;
    private Double totalAmount;
    private Double discountAmount;
    private Double netPayableAmount;
    private Date orderDate;

    public Orders() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    public Product getProductId() {
        return productId;
    }

    public void setProductId(Product productId) {
        this.productId = productId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Discounts getDiscount() {
        return discount;
    }

    public void setDiscount(Discounts discount) {
        this.discount = discount;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Double getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(Double discountAmount) {
        this.discountAmount = discountAmount;
    }

    public Double getNetPayableAmount() {
        return netPayableAmount;
    }

    public void setNetPayableAmount(Double netPayableAmount) {
        this.netPayableAmount = netPayableAmount;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

}
