/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.retailstore.service;

import com.retailstore.beans.Bill;
import com.retailstore.models.Discounts;
import com.retailstore.models.Orders;
import com.retailstore.models.Product;
import com.retailstore.models.User;
import com.retailstore.repositories.DiscountRepository;
import com.retailstore.repositories.ProductRepository;
import com.retailstore.repositories.UserRepository;
import com.retailstore.utilities.Utility;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Erick Ngari
 */
@Service
public class RetailService {

    private static final Logger LOGGER = LoggerFactory.getLogger(RetailService.class);
    @Autowired
    ProductRepository productRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    DiscountRepository discountRepository;
    @Autowired
    Utility utility;

    public Map<String, String> findNetPayable(Bill bill) {
        Map<String, String> params = new HashMap<>();
        try {
            User user = userRepository.findUser(bill.getUserId());
            if (user == null) {
                throw new IOException("User doesn't exist");
            }
            Product product = productRepository.findProduct(bill.getProductId());
            if (product == null) {
                throw new Exception("Product doesn't exist");
            }

            if (product.getQuantity() < bill.getQuantity()) {
                throw new Exception("Available product quantity " + product.getQuantity());
            }

            Date currentDate = new Date();
            Double totalCost = product.getItemCost() * bill.getQuantity();
            Discounts discount = null;
            Double totalDiscountAmount = 0.00;
            Double netAmount = 0.00;
            if (product.getCategory() == Product.Categories.Grocery) {
                LOGGER.info("Grocery Discount");
                int num100Bills = (int) (totalCost / 100);
                discount = discountRepository.getDiscount("FixedEvery100OnTheBillDiscount");
                totalDiscountAmount = discount.getDiscountValue() * num100Bills;
            } else {
                if (user.getIsEmployee()) {
                    LOGGER.info("Employee Discount");
                    discount = discountRepository.getDiscount("PercentageStoreEmployeeDiscount");
                    totalDiscountAmount = (totalCost * discount.getDiscountValue()) / 100;
                } else if (user.getIsAffiliate()) {
                    LOGGER.info("Affiliate Discount");
                    discount = discountRepository.getDiscount("PercentStoreAffiliateDiscount");
                    totalDiscountAmount = (totalCost * discount.getDiscountValue()) / 100;
                } else {
                    Integer yearsDifference = utility.yearBetweenDates(user.getDateRegistered(), currentDate);
                    if (yearsDifference >= 2) {
                        LOGGER.info("Over 2 Years Discount");
                        discount = discountRepository.getDiscount("PercentOverTwoYearsCustomerDiscount");
                        totalDiscountAmount = (totalCost * discount.getDiscountValue()) / 100;
                    } else {
                        LOGGER.info("Every 100 On The Bill Discount");
                        int num100Bills = (int) (totalCost / 100);
                        discount = discountRepository.getDiscount("FixedEvery100OnTheBillDiscount");
                        totalDiscountAmount = discount.getDiscountValue() * num100Bills;
                    }
                }
            }
            netAmount = totalCost - totalDiscountAmount;
            Orders order = new Orders();
            order.setUserId(new User(bill.getUserId()));
            order.setProductId(new Product(bill.getProductId()));
            order.setQuantity(bill.getQuantity());
            order.setDiscountAmount(totalDiscountAmount);
            order.setNetPayableAmount(netAmount);
            order.setTotalAmount(totalCost);
            order.setOrderDate(currentDate);

            product.setQuantity((product.getQuantity() - bill.getQuantity()));

            params.put("Result", "OK");
            params.put("Customer", user.getFirstName() + " " + user.getSurName());
            params.put("Product", product.getProductName());
            params.put("ItemCost", utility.formatCurrency(product.getItemCost()));
            params.put("Quantity", bill.getQuantity() + "");
            params.put("TotalCost", utility.formatCurrency(totalCost));
            params.put("Discount", utility.formatCurrency(totalDiscountAmount));
            params.put("NetAmount", utility.formatCurrency(netAmount));
            return params;
        } catch (Exception e) {
            params.put("Result", e.getMessage());
        }
        return params;
    }
}
