/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.retailstore.controllers;

import com.retailstore.beans.Bill;
import com.retailstore.models.Product;
import com.retailstore.models.User;
import com.retailstore.service.ProductService;
import com.retailstore.service.RetailService;
import com.retailstore.service.UserService;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Erick Ngari
 */
@RestController
@RequestMapping("/api/")
public class RetailController {

    private static final Logger LOGGER = LoggerFactory.getLogger(RetailController.class);
    @Autowired
    RetailService retailService;
    @Autowired
    ProductService productService;
    @Autowired
    UserService userService;

    @PostConstruct
    public void init() {

    }

    @GetMapping(path = "/getProducts")
    public List<Product> getProducts() {
        List<Product> list = productService.getProducts();
        return list;
    }

    @GetMapping(path = "/getUsers")
    public ResponseEntity<List<User>> getUsers() {
        List<User> list = userService.getUsers();
        return new ResponseEntity<>(list, new HttpHeaders(), HttpStatus.OK);
    }

    @PostMapping(path = "/findNetPayable")
    @ResponseBody
    public ResponseEntity<Map<String, String>> findNetPayable(@RequestBody Bill bill) {
        Map<String, String> result = retailService.findNetPayable(bill);
        LOGGER.info("Order info: " + result.toString());
        return new ResponseEntity<>(result, new HttpHeaders(), HttpStatus.OK);
    }
}
