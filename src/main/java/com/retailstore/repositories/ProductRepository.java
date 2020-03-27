/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.retailstore.repositories;

import com.retailstore.models.Product;
import com.retailstore.utilities.Utility;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Erick Ngari
 */
@Repository
public class ProductRepository {

    @Autowired
    Utility utility;
    private final List<Product> PRODUCTS = new ArrayList<>();

    @PostConstruct
    public void init() {
        PRODUCTS.add(new Product(1, "Rice", "1 Kg", 50, 175.00, Product.Categories.Grocery));
        PRODUCTS.add(new Product(2, "Flour", "2 Kg", 100, 125.00, Product.Categories.Grocery));
        PRODUCTS.add(new Product(3, "Smart TV", "Full Hd, 32 inch", 15, 17500.00, Product.Categories.Electronics));
        PRODUCTS.add(new Product(4, "Paper Punch", "Office", 30, 580.00, Product.Categories.Stationery));
        PRODUCTS.add(new Product(5, "Stapler", "Office paper stapler", 30, 480.00, Product.Categories.Stationery));
        PRODUCTS.add(new Product(6, "Soap", "With glycerine 200 grams", 200, 275.00, Product.Categories.Other));
        PRODUCTS.add(new Product(7, "Tooth Paste", "160ml", 100, 175.00, Product.Categories.Other));
    }

    public List<Product> getProducts() {
        return PRODUCTS;
    }

    public Product findProduct(Integer id) {
        for (Product p : getProducts()) {
            if (Objects.equals(p.getId(), id)) {
                return p;
            }
        }
        return null;
    }
}
