package com.example.banqueproject.dao.impl;

import com.example.banqueproject.dao.DBConnection;
import com.example.banqueproject.dao.inte.UserDAO;
import com.example.banqueproject.entity.Clients;

import java.sql.Connection;

public class UserDAOImpl implements UserDAO {
    private Connection conn;

    @Override
    public void save(Clients client){
        conn = DBConnection.getConnection();

        String sql = "INSERT INTO clients (email, nom, adresse, codePostal, ville, tel, pwd)"
    }
}
