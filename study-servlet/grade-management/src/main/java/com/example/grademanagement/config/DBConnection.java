package com.example.grademanagement.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import jakarta.servlet.ServletContext;

public class DBConnection {

    public static Connection getConnection(ServletContext context) throws SQLException, ClassNotFoundException {
        String pilot = context.getInitParameter("jdbc.Driver");
        String url = context.getInitParameter("localisation");
        String user = "saad";
        String pass = "Saad@1234";

        Class.forName(pilot);
        return DriverManager.getConnection(url, user, pass);
    }
}
