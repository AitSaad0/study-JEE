package com.example.grademanagement.dashboard;

import com.example.grademanagement.config.DBConnection;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
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
        try {
            this.conn = DBConnection.getConnection(getServletContext());
            logger.info("AuthFilter: Connection successful");
        } catch (Exception e) {
            throw new ServletException("Database connection failed in Filter", e);
        }
    }



    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession(false);
        if(session != null){
            String name = (String)session.getAttribute("name");
            String email = (String)session.getAttribute("email");
            String role = (String)session.getAttribute("role");

            PrintWriter out = response.getWriter();
            out.println("<HTML> <BODY>");
            out.println("<h1> hello " + name + " </h1> <br> <br>");
            out.println("<h1> email " + email + " </h1> <br> <br>");
            out.println("<h1> role " + role + " </h1> <br> <br>");
            out.println("<h3> your grade should be here </h3>");
            out.println("</BODY> </HTML>");
        }


        /*
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
         */

    }

}
