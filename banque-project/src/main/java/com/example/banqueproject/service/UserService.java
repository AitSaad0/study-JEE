package com.example.banqueproject.service;

import com.example.banqueproject.entity.Users;

public interface UserService {
    public boolean register(Users client);
    public Users authenticate(String email, String mdp);

}
