package com.example.banqueproject.dao.inte;

import com.example.banqueproject.entity.Clients;

import java.sql.ResultSet;

public interface UserDAO {
    public boolean save(Clients client);
    public Clients findByEmail(String email);
}
