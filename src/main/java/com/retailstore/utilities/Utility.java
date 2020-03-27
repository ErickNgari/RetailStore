/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.retailstore.utilities;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 *
 * @author Erick Ngari
 */
@Component
public class Utility {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(Utility.class);
    
    public Date formatDate(String _date) {
        Date date = null;
        try {
            DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            date = (Date) formatter.parse(_date);
        } catch (Exception e) {
            
        }
        return date;
    }
    
    public int yearBetweenDates(Date startDate, Date endDate) {
        int diffInYears = 0;
        if (startDate != null && endDate != null) {
            long diff = endDate.getTime() - startDate.getTime();
            diffInYears = (int) (diff / (60 * 60 * 1000 * 24 * 365.0));
        }
        return diffInYears;
    }
    
    public String formatCurrency(Double d) {
        d = Math.round(d * 100.0) / 100.0;
        DecimalFormat df = new DecimalFormat("#.00");
        return df.format(d);
    }
}
