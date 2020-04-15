/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.retailstore.service;

import com.retailstore.models.User;
import com.retailstore.repositories.UserRepository;
import java.util.List;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Erick Ngari
 */
@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public List<User> getUsers() {
        List<User> list = userRepository.getUsers();
        return list;
    }

    public User findUser(Integer id) throws Exception {
        for (User u : getUsers()) {
            if (Objects.equals(u.getId(), id)) {
                return u;
            }
        }
        throw new Exception("User doesn't exist");
    }
}
