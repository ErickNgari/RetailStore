package com.retailstore;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.retailstore.beans.Bill;
import com.retailstore.service.ProductService;
import com.retailstore.service.RetailService;
import com.retailstore.service.UserService;
import com.retailstore.utilities.Utility;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.junit.Before;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import static org.mockito.Mockito.when;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest
class RetailstoreApplicationUnitTests {

    private static final Logger LOGGER = LoggerFactory.getLogger(RetailstoreApplicationUnitTests.class);
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    UserService userService;

    @MockBean
    ProductService productService;

    @MockBean
    RetailService retailService;

    @MockBean
    Utility utility;

    Map<String, String> expectedResponse = new HashMap<>();

    @Before
    public void init() {
        expectedResponse.put("Result", "OK");
        expectedResponse.put("Customer", "Paul N");
        expectedResponse.put("Product", "Flour");
        expectedResponse.put("ItemCost", "1500.00");
        expectedResponse.put("Quantity", "12");
        expectedResponse.put("TotalCost", "1500.00");
        expectedResponse.put("Discount", "75.00");
        expectedResponse.put("NetAmount", "1425.00");
    }

    @Test
    public void testfindNetPayableIsOk() throws Exception {
        Bill bill = new Bill();
        bill.setUserId(3);
        bill.setProductId(2);
        bill.setQuantity(12);
        //User user = new User(1, "Arnold", "M", "arnold@gmail.com", Boolean.TRUE, Boolean.FALSE, utility.formatDate("2019-05-20 08:10:00"));
        Mockito.when(retailService.findNetPayable(bill)).thenReturn(expectedResponse);
        mockMvc.perform(MockMvcRequestBuilders.post("/api/findNetPayable")
                .content(objToJsonString(bill))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print());
    }

    @Test
    public void testfindNetPayableError() throws Exception {
        Bill bill = null;
        Mockito.when(retailService.findNetPayable(bill)).thenReturn(expectedResponse);
        mockMvc.perform(MockMvcRequestBuilders.post("/api/findNetPayable")
                .content(objToJsonString(bill))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andDo(print());
    }

    @Test
    public void testValidDateFormat() throws Exception {
        Date d = new Date();
        when(utility.formatDate(d.toString())).thenReturn(d);
        assertEquals(utility.formatDate(d.toString()), d);
    }

    @Test
    public void testInvalidDateFormat() throws Exception {
        when(utility.formatDate(null)).thenReturn(null);
        assertEquals(utility.formatDate(null), null);
    }

    public String objToJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
