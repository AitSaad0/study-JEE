package com.example.studyservlet;

import java.io.*;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //5- define the HTTP response params
        //here is a HTML page
        response.setContentType("text/html");

        //1- GET all data submitted by the client
        String name = request.getParameter("name");
        String age = request.getParameter("age");

        PrintWriter out = response.getWriter();
        //4- format the result in a doc (HTML page)
        out.println("<html><body>");
        out.println("<h1> hello " + name + " ur age is " + age + "</h1>");
        out.println("</body></html>");
    }

    public void destroy() {
    }
}