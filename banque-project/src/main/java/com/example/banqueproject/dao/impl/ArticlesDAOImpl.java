package com.example.banqueproject.dao.impl;

import com.example.banqueproject.dao.DBConnection;
import com.example.banqueproject.dao.inte.ArticlesDAO;
import com.example.banqueproject.dto.ArticlesDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ArticlesDAOImpl implements ArticlesDAO {


    @Override
    public List<ArticlesDto> findByCategorie(int idCat){
        String sql = "SELECT * FROM articles WHERE categorie = ?";
        List<ArticlesDto> articles = new ArrayList<>();
        try(Connection conn = DBConnection.getConnection();
            PreparedStatement st = conn.prepareStatement(sql)){
            st.setInt(1, idCat);
            ResultSet set = st.executeQuery();
            while(set.next()){
                ArticlesDto article = new ArticlesDto(
                        set.getInt("codeArticle"),
                        set.getString("designation"),
                        set.getDouble("prix"),
                        set.getInt("stock"),
                        set.getInt("categorie"),
                        set.getString("photo"),
                        set.getString("title"),
                        set.getString("author")
                );
                articles.add(article);
            }

        }catch(SQLException e){
            System.out.println("error in ArticlesDAOimpl : findByCategorie");
            System.out.println(e);
        }

        return articles;
    }

    @Override
    public List<ArticlesDto> findAll() {
        List<ArticlesDto> articles = new ArrayList<>();
        String sql = "SELECT * FROM articles";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement st = conn.prepareStatement(sql);
             ResultSet rs = st.executeQuery()) {

            while (rs.next()) {
                ArticlesDto article = new ArticlesDto(
                        rs.getInt("codeArticle"),
                        rs.getString("designation"),
                        rs.getDouble("prix"),
                        rs.getObject("stock", Integer.class),      // NULL-safe
                        rs.getObject("categorie", Integer.class),  // NULL-safe
                        rs.getString("photo"),
                        rs.getString("title"),
                        rs.getString("author")
                );
                articles.add(article);
            }

        } catch (SQLException e) {
            System.out.println("Error in ArticlesDAOImpl.findAll()");
            e.printStackTrace();
        }

        return articles; // NEVER return null
    }
}
