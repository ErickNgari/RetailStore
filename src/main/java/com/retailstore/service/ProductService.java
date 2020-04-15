/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.retailstore.service;

import com.retailstore.models.Product;
import com.retailstore.repositories.ProductRepository;
import java.util.List;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Erick Ngari
 */
@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public List<Product> getProducts() {
        List<Product> list = productRepository.getProducts();
        return list;
    }

    public Product findProduct(Integer id) throws Exception {
        for (Product p : getProducts()) {
            if (Objects.equals(p.getId(), id)) {
                return p;
            }
        }
        throw new Exception("Product doesn't exist");
    }
}
