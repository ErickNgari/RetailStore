/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.retailstore.service;

import com.retailstore.models.Discounts;
import com.retailstore.repositories.DiscountRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Erick Ngari
 */
@Service
public class DiscountService {

    @Autowired
    DiscountRepository discountRepository;

    public List<Discounts> getDiscounts() {
        return discountRepository.getDiscounts();
    }

    public Discounts getDiscount(String type) {
        Discounts discount = null;
        for (Discounts d : getDiscounts()) {
            if (d.getDiscountType().equals(type)) {
                discount = d;
                break;
            }
        }
        return discount;
    }
}
