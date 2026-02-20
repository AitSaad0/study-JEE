package com.example.banqueproject.dao.impl;

import com.example.banqueproject.dao.DBConnection;
import com.example.banqueproject.dao.inte.UserDAO;
import com.example.banqueproject.entity.Clients;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAOImpl implements UserDAO {
    private Connection conn;

    @Override
    public boolean save(Clients client){
        conn = DBConnection.getConnection();

        String sql = "INSERT INTO clients (email, nom, adresse, codePostal, ville, tel, pwd) values (?,?,?,?,?,?,?)";

        try(PreparedStatement pstm = conn.prepareStatement(sql)){
            pstm.setString(1, client.getEmail());
            pstm.setString(2, client.getNom());
            pstm.setString(3, client.getAdresse());
            pstm.setString(4, client.getCodePostal());
            pstm.setString(5, client.getVille());
            pstm.setString(6, client.getTel());
            pstm.setString(7, client.getMdp());
            int rowsInserted = pstm.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("A new student was inserted successfully!");
                return true;
            }
        }catch(SQLException e){
            System.out.println(e);
        }

        return false;
    }


    @Override
    public Clients findByEmail(String email) {
        conn = DBConnection.getConnection();
        String sql = "SELECT * FROM clients WHERE email = ?";

        try (PreparedStatement pstm = conn.prepareStatement(sql)) {

            pstm.setString(1, email);
            try (ResultSet rs = pstm.executeQuery()) {
                if (rs.next()) {
                    return mapToClient(rs); // Méthode utilitaire pour mapper
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private Clients mapToClient(ResultSet rs) throws SQLException {
        return new Clients(
                rs.getInt("id"),
                rs.getString("email"),
                rs.getString("nom"),
                rs.getString("adresse"),
                rs.getString("codePostal"),
                rs.getString("ville"),
                rs.getString("tel"),
                rs.getString("pwd")
        );
    }
}

