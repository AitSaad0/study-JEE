package com.example.banqueproject.dao.impl;

import com.example.banqueproject.dao.DBConnection;
import com.example.banqueproject.dao.inte.UserDAO;
import com.example.banqueproject.entity.Users;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAOImpl implements UserDAO {

    @Override
    public boolean save(Users user){

        String sql = "INSERT INTO users (email, name, address, zip, city, tel, password) values (?,?,?,?,?,?,?)";

        try(Connection conn = DBConnection.getConnection();
            PreparedStatement pstm = conn.prepareStatement(sql)){
            pstm.setString(1, user.getEmail());
            pstm.setString(2, user.getName());
            pstm.setString(3, user.getAddress());
            pstm.setString(4, user.getZip());
            pstm.setString(5, user.getCity());
            pstm.setString(6, user.getTel());
            pstm.setString(7, user.getPassword());
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
    public Users findByEmail(String email) {
        String sql = "SELECT * FROM users WHERE email = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstm = conn.prepareStatement(sql)) {

            pstm.setString(1, email);
            try (ResultSet rs = pstm.executeQuery()) {
                if (rs.next()) {
                    return mapToClient(rs);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private Users mapToClient(ResultSet rs) throws SQLException {
        return new Users(
                rs.getInt("id"),
                rs.getString("email"),
                rs.getString("name"),
                rs.getString("address"),
                rs.getString("zip"),
                rs.getString("city"),
                rs.getString("tel"),
                rs.getString("password")
        );
    }
}

