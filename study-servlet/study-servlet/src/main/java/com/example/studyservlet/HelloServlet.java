
package com.example.studyservlet;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Enumeration;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

public class HelloServlet extends HttpServlet {
    private String message;
    private Connection conn;
    public void init() throws ServletException {
        System.out.println("Servlet init called!");

        // Set default driver and URL in case init-param is missing
        String pilot = getServletContext().getInitParameter("jdbc.Driver");
        if (pilot == null) pilot = "com.mysql.cj.jdbc.Driver";

        String db = getServletContext().getInitParameter("localisation");
        if (db == null) db = "jdbc:mysql://localhost:3306/student_db?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";

        try {
            Class.forName(pilot);
            conn = DriverManager.getConnection(db,    "saad", "Saad@1234");
            log("DB Connected!");
        } catch (ClassNotFoundException e) {
            log("JDBC Driver not found: " + pilot, e);
            throw new ServletException(e);
        } catch (SQLException e) {
            log("Cannot connect to database: " + db, e);
            throw new ServletException(e);
        }
    }


    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //5- define the HTTP response params
        //here is a HTML page
        response.setContentType("text/html");

        //1- GET all data submitted by the client
        String name = request.getParameter("name");
        String age = request.getParameter("age");

        Enumeration<String> names = request.getParameterNames();
        while(names.hasMoreElements()){
            System.out.println(names.nextElement());
        }

        String urlParmas = request.getQueryString();

        System.out.println(request.getServerName());
        PrintWriter out = response.getWriter();
        //4- format the result in a doc (HTML page)
        out.println("<html><body>");
        out.println("<h1> hello " + name + " ur age is " + age + " ur urlParmas is " + urlParmas + "</h1>");
        out.println("</body></html>");
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException{
        getServletContext().log("-------------------------------------------------");
        getServletContext().log("Poste Hôte client : " + request.getRemoteHost());
        getServletContext().log("Adresse IP du client : " + request.getRemoteAddr());
        getServletContext().log("Paramètres envoyés : " + request.getQueryString());
        getServletContext().log("Numéro de port du client : " + request.getRemotePort());
        getServletContext().log("Nom du client : " + request.getRemoteUser());
        getServletContext().log("-------------------------------------------------");

        String name = request.getParameter("name");
        int age = Integer.parseInt(request.getParameter("age"));
        String email = request.getParameter("email");
        PrintWriter out = response.getWriter();


        String sql = "INSERT INTO students ( name, age, email) VALUES (?, ?, ?)";
        try(PreparedStatement stmt = conn.prepareStatement(sql)){

            stmt.setString(1, name);
            stmt.setInt(2, age);
            stmt.setString(3, email);
            stmt.executeUpdate();
            stmt.close();

        }catch (SQLException e){

        }catch(NullPointerException e ){
            e.printStackTrace();  // prints full SQL error in console
            out.println("<h1>SQL Error: " + e.getMessage() + "</h1>");
        }
    }
    public void destroy() {
    }
}