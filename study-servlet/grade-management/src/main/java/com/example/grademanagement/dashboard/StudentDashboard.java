package com.example.grademanagement.dashboard;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class StudentDashboard extends HttpServlet {

    private Connection conn;
    private static final Logger logger = LoggerFactory.getLogger(StudentDashboard.class.getName());
    public void init() throws ServletException {

        String pilot = getServletContext().getInitParameter("jdbc.Driver");
        String db = getServletContext().getInitParameter("localisation");

        try{
            Class.forName(pilot);
            conn = DriverManager.getConnection(db,    "saad", "Saad@1234");
            logger.info("db connected");
        } catch (ClassNotFoundException e) {
            logger.info("JDBC Driver not found: {}", pilot);
            throw new ServletException(e);
        }catch (SQLException e){
            logger.info("Cannot connect to database: {} ", db);
            throw new ServletException(e);
        }

    }


    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        logger.info("we are here");
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




        PrintWriter out = response.getWriter();
        out.println("<HTML> <BODY>");
        out.println("<h1> hello " + fullName + " </h1> <br> <br>");
        out.println("<h3> your grade should be here </h3>");
        out.println("</BODY> </HTML>");

    }
}
