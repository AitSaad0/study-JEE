package com.example.banqueproject.dao.inte;

import com.example.banqueproject.entity.Users;

public interface UserDAO {
    public boolean save(Users client);
    public Users findByEmail(String email);
}
