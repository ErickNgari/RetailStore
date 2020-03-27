/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.retailstore.repositories;

import com.retailstore.models.User;
import com.retailstore.utilities.Utility;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Erick Ngari
 */
@Repository
public class UserRepository {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserRepository.class);
    @Autowired
    Utility utility;
    private static final List<User> USERS = new ArrayList<>();

    @PostConstruct
    public void init() {
        USERS.add(new User(1, "Arnold", "M", "arnold@gmail.com", Boolean.TRUE, Boolean.FALSE, utility.formatDate("2019-05-20 08:10:00")));//employee
        USERS.add(new User(2, "John", "K", "john@gmail.com", Boolean.FALSE, Boolean.TRUE, utility.formatDate("2019-08-17 08:10:00")));//affiliate
        USERS.add(new User(3, "Paul", "N", "paul@gmail.com", Boolean.FALSE, Boolean.FALSE, utility.formatDate("2019-07-20 10:10:00")));//Every 100 On The Bill Discount
        USERS.add(new User(4, "Samuel", "T", "samuel@gmail.com", Boolean.FALSE, Boolean.FALSE, utility.formatDate("2014-03-11 08:10:00")));//Long time customer
    }

    public List<User> getUsers() {
        return USERS;
    }

    public User findUser(Integer id) {
        for (User u : getUsers()) {
            if (Objects.equals(u.getId(), id)) {
                return u;
            }
        }
        return null;
    }
}
