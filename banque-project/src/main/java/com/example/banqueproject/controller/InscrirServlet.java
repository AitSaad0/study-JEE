package com.example.banqueproject.controller;

import com.example.banqueproject.dto.ClientDto;
import com.example.banqueproject.dto.mapper.ClientMapper;
import com.example.banqueproject.entity.Clients;
import com.example.banqueproject.service.UserService;
import com.example.banqueproject.service.impl.UserServiceImpl;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

public class InscrirServlet extends HttpServlet {

    private UserService userService = new UserServiceImpl();

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        RequestDispatcher rd = request.getRequestDispatcher("/inscrir.jsp");
        rd.forward(request, response);
    }


    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        HttpSession session = request.getSession();
        String email = request.getParameter("email");
        String nom = request.getParameter("nom");
        String adresse = request.getParameter("adresse");
        String codePostal = request.getParameter("codePostal");
        String ville = request.getParameter("ville");
        String tel = request.getParameter("tel");
        String mdp = request.getParameter("mdp");

        Clients client = new Clients(email, nom, adresse, codePostal, ville, tel, mdp);
        boolean result = userService.register(client);
        ClientDto clientDto = ClientMapper.clientToCLientDto(client);
        if(result){
            session.setAttribute("client", clientDto);
            System.out.println(clientDto.nom());
            RequestDispatcher rd = request.getRequestDispatcher("/acceuil.jsp");
            rd.forward(request, response);
        }else{
            request.setAttribute("errorMessage", "user already exist");
            RequestDispatcher rd = request.getRequestDispatcher("/inscrir.jsp");
            rd.forward(request, response);
        }
    }
}
