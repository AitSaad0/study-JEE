package com.example.banqueproject.service.impl;

import com.example.banqueproject.dao.impl.UserDAOImpl;
import com.example.banqueproject.dao.inte.UserDAO;
import com.example.banqueproject.entity.Users;
import com.example.banqueproject.service.UserService;

public class UserServiceImpl implements UserService {

    private UserDAO userDAO = new UserDAOImpl();

    @Override
    public boolean register(Users client){
        return userDAO.save(client);
    }


    @Override
    public Users authenticate(String email, String mdp) {
        Users client = userDAO.findByEmail(email);

        if (client != null && client.getPassword().equals(mdp)) {
            return client;
        }

        return null;
    }
}
