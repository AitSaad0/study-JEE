package com.example.banqueproject.service;

import com.example.banqueproject.entity.Clients;

public interface UserService {
    public boolean register(Clients client);
    public Clients authenticate(String email, String mdp);

}
