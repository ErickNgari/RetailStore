/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.retailstore;

import org.json.JSONObject;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 *
 * @author Erick Ngari
 */
@RunWith(SpringRunner.class)
@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
        classes = RetailstoreApplication.class
)
@AutoConfigureMockMvc
public class RetailstoreApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testfindNetPayableDiscountForGroceryItems() throws Exception {
        //Discount for Grocery items
        JSONObject jSONObjectRequest = new JSONObject();
        jSONObjectRequest.put("userId", 1);
        jSONObjectRequest.put("productId", 1);
        jSONObjectRequest.put("quantity", 1);
        mockMvc.perform(MockMvcRequestBuilders.post("/api/findNetPayable")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jSONObjectRequest.toString())
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print());
    }

    @Test
    public void testfindNetPayableDiscountForEmployee() throws Exception {
        //Discount For Employee
        JSONObject jSONObjectRequest = new JSONObject();
        jSONObjectRequest.put("userId", 1);
        jSONObjectRequest.put("productId", 3);
        jSONObjectRequest.put("quantity", 2);
        mockMvc.perform(MockMvcRequestBuilders.post("/api/findNetPayable")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jSONObjectRequest.toString())
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print());
    }

    @Test
    public void testfindNetPayableDiscountForAffiliateCustomer() throws Exception {
        //Discount For Affiliate customer
        JSONObject jSONObjectRequest = new JSONObject();
        jSONObjectRequest.put("userId", 2);
        jSONObjectRequest.put("productId", 5);
        jSONObjectRequest.put("quantity", 1);
        mockMvc.perform(MockMvcRequestBuilders.post("/api/findNetPayable")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jSONObjectRequest.toString())
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    public void testfindNetPayableDiscountForLongTermCustomer() throws Exception {
        //Discount For Long Term Customer 2 years
        JSONObject jSONObjectRequest = new JSONObject();
        jSONObjectRequest.put("userId", 4);
        jSONObjectRequest.put("productId", 6);
        jSONObjectRequest.put("quantity", 4);
        mockMvc.perform(MockMvcRequestBuilders.post("/api/findNetPayable")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jSONObjectRequest.toString())
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    public void testfindNetPayableDiscountOnEvery100Bill() throws Exception {
        //Discount On Every $100 Bill
        JSONObject jSONObjectRequest = new JSONObject();
        jSONObjectRequest.put("userId", 3);
        jSONObjectRequest.put("productId", 7);
        jSONObjectRequest.put("quantity", 20);
        mockMvc.perform(MockMvcRequestBuilders.post("/api/findNetPayable")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jSONObjectRequest.toString())
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    public void testfindNetPayableUserNotFound() throws Exception {
        //User doen't exist
        JSONObject jSONObjectRequest = new JSONObject();
        jSONObjectRequest.put("userId", 20);
        jSONObjectRequest.put("productId", 100);
        jSONObjectRequest.put("quantity", 2);
        mockMvc.perform(MockMvcRequestBuilders.post("/api/findNetPayable")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jSONObjectRequest.toString())
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print());
    }
    
    @Test
    public void testfindNetPayableNoProduct() throws Exception {
        //Product doen't exist
        JSONObject jSONObjectRequest = new JSONObject();
        jSONObjectRequest.put("userId", 1);
        jSONObjectRequest.put("productId", 100);
        jSONObjectRequest.put("quantity", 2);
        mockMvc.perform(MockMvcRequestBuilders.post("/api/findNetPayable")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jSONObjectRequest.toString())
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print());
    }

    @Test
    public void testfindNetPayableLargeQuantity() throws Exception {
        //Quantity exeeded/ not in stock
        JSONObject jSONObjectRequest = new JSONObject();
        jSONObjectRequest.put("userId", 1);
        jSONObjectRequest.put("productId", 2);
        jSONObjectRequest.put("quantity", 200000);
        mockMvc.perform(MockMvcRequestBuilders.post("/api/findNetPayable")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jSONObjectRequest.toString())
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print());
    }

    @Test
    public void testfindNetPayableError() throws Exception {
        //Exception
        mockMvc.perform(MockMvcRequestBuilders.post("/api/findNetPayable")
                .contentType(MediaType.APPLICATION_JSON)
                .content("")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andDo(print());
    }

    @Test
    public void testgetProducts() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/getProducts"))
                .andExpect(status().isOk())
                .andDo(print());

    }

    @Test
    public void getUsers() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/getUsers"))
                .andExpect(status().isOk())
                .andDo(print());

    }
    
    
}
