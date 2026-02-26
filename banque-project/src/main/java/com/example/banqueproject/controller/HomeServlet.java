package com.example.banqueproject.controller;

import com.example.banqueproject.service.UserService;
import com.example.banqueproject.service.impl.UserServiceImpl;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

public class HomeServlet extends HttpServlet {

    private UserService userService = new UserServiceImpl();

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        response.setContentType("text/html");
        RequestDispatcher rd = request.getRequestDispatcher("/home.jsp");
        rd.forward(request, response);

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        HttpSession session = request.getSession(false);
        if(session != null){
            RequestDispatcher rd = request.getRequestDispatcher("/dashboard.jsp");
            rd.forward(request, response);
            return;
        }else{
            RequestDispatcher rd = request.getRequestDispatcher("/auth.jsp");
            rd.forward(request, response);
            return;
        }
    }
}
