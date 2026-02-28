package com.example.banqueproject.controller;

import com.example.banqueproject.dto.CommandeDetailDto;
import com.example.banqueproject.dto.UserDto;
import com.example.banqueproject.service.CommandesService;
import com.example.banqueproject.service.impl.CommandesServiceImpl;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

public class CommandesServlet extends HttpServlet {

    private final CommandesService commandesService = new CommandesServiceImpl();

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        HttpSession session = request.getSession(false);
        if (session == null) {
            response.sendRedirect(request.getContextPath() + "/auth");
            return;
        }

        UserDto user = (UserDto) session.getAttribute("user");
        if (user == null) {
            response.sendRedirect(request.getContextPath() + "/auth");
            return;
        }

        List<CommandeDetailDto> commandes = commandesService.getCommandeDetails(user.id());
        request.setAttribute("commandes", commandes);

        RequestDispatcher rd = request.getRequestDispatcher("/commandes.jsp");
        rd.forward(request, response);
    }
}