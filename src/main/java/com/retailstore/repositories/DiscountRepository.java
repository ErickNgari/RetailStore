/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.retailstore.repositories;

import com.retailstore.models.Discounts;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Erick Ngari
 */
@Repository
public class DiscountRepository {

    private static final List<Discounts> DISCOUNTS = new ArrayList<>();

    static {
        DISCOUNTS.add(new Discounts(1, "PercentageStoreEmployeeDiscount", 30.00));
        DISCOUNTS.add(new Discounts(2, "PercentStoreAffiliateDiscount", 10.00));
        DISCOUNTS.add(new Discounts(3, "PercentOverTwoYearsCustomerDiscount", 5.00));
        DISCOUNTS.add(new Discounts(4, "FixedEvery100OnTheBillDiscount", 5.00));
    }

    public List<Discounts> getDiscounts() {
        return DISCOUNTS;
    }

}
