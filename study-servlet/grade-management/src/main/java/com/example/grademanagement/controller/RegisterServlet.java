package com.example.grademanagement.controller;

import com.example.grademanagement.config.DBConnection;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RegisterServlet extends HttpServlet {
    private static final Logger logger = LoggerFactory.getLogger(RegisterServlet.class.getName());
    private Connection conn;

    public void init() throws ServletException {
        try {
            this.conn = DBConnection.getConnection(getServletContext());
            logger.info("AuthFilter: Connection successful");
        } catch (Exception e) {
            throw new ServletException("Database connection failed in Filter", e);
        }
    }


    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String fullName = request.getParameter("full_name");
        String email = request.getParameter("email");
        String role = request.getParameter("role");
        String password = request.getParameter("password");

        String sql = "INSERT INTO users (full_name, email, role, password) VALUES (?, ?, ?, ?)";

        try(PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setString(1, fullName);
            stmt.setString(2, email);
            stmt.setString(3, role);
            stmt.setString(4, password);
            stmt.executeUpdate();
        }catch(SQLException e){
            System.out.println("insert data failed : "+ e );
        }

        if ("student".equalsIgnoreCase(role) || "prof".equalsIgnoreCase(role)) {
            response.sendRedirect(request.getContextPath() + "/auth.html?registered=true");
        } else {
            response.sendRedirect(request.getContextPath() + "/register.html?error=invalid_role");
        }

        logger.info("we are at the end of register servlet");

    }

}
