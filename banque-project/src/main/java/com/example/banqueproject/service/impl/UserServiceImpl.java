package com.example.banqueproject.service.impl;

import com.example.banqueproject.dao.impl.UserDAOImpl;
import com.example.banqueproject.dao.inte.UserDAO;
import com.example.banqueproject.entity.Clients;
import com.example.banqueproject.service.UserService;

public class UserServiceImpl implements UserService {

    private UserDAO userDAO = new UserDAOImpl();

    @Override
    public boolean register(Clients client){
        return userDAO.save(client);
    }


    @Override
    public Clients authenticate(String email, String mdp) {
        Clients client = userDAO.findByEmail(email);

        if (client != null && client.getMdp().equals(mdp)) {
            return client;
        }

        return null;
    }
}
