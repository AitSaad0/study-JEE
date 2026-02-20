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

public class IdentifierServlet extends HttpServlet {

    private UserService userService = new UserServiceImpl();

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        RequestDispatcher rd = request.getRequestDispatcher("/identifier.jsp");
        rd.forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        HttpSession session = request.getSession();
        String email = request.getParameter("email");
        String mdp = request.getParameter("mdp");

        Clients client = userService.authenticate(email, mdp);
        if(client == null){
            request.setAttribute("errorMessage", "credentiel error");
            request.getRequestDispatcher("identifier.jsp").forward(request, response);
            return;
        }

        ClientDto clientDto = ClientMapper.clientToCLientDto(client);
        session.setAttribute("client", clientDto);
        RequestDispatcher rd = request.getRequestDispatcher("/acceuil.jsp");
        rd.forward(request, response);
    }
}
