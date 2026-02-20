package com.example.banqueproject.controller;

import com.example.banqueproject.entity.Clients;
import com.example.banqueproject.service.UserService;
import com.example.banqueproject.service.impl.UserServiceImpl;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class InscrirServlet extends HttpServlet {

    private UserService userService = new UserServiceImpl();

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        String email = request.getParameter("email");
        String nom = request.getParameter("nom");
        String adresse = request.getParameter("adresse");
        String codePostal = request.getParameter("codePostal");
        String ville = request.getParameter("ville");
        String tel = request.getParameter("tel");
        String mdp = request.getParameter("mdp");

        Clients client = new Clients(email, nom, adresse, codePostal, ville, tel, mdp);
        boolean result = userService.register(client);
        RequestDispatcher rd = request.getRequestDispatcher("/acceuil.jsp");
        if(result){
            request.setAttribute("nom", nom);
            rd.forward(request, response);
        }
    }
}
