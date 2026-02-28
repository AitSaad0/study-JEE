package com.example.banqueproject.dao.impl;

import com.example.banqueproject.dao.DBConnection;
import com.example.banqueproject.dao.inte.CategoriesDao;
import com.example.banqueproject.entity.Categories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoriesDAOImpl implements CategoriesDao {


    @Override
    public List<Categories> findAll() {
        List<Categories> liste = new ArrayList<>();
        String sql = "SELECT idCat, cat FROM categories";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                Categories c = new Categories();
                c.setIdCat(rs.getInt("idCat"));
                c.setCat(rs.getString("cat"));
                liste.add(c);
            }
        } catch (SQLException e) {
            System.out.println("Erreur lors de la récupération : " + e.getMessage());
        }

        return liste;
    }
}
