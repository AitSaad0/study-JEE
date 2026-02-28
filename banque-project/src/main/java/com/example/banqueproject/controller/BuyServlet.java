package com.example.banqueproject.controller;

import com.example.banqueproject.dto.ArticlesDto;
import com.example.banqueproject.dto.UserDto;
import com.example.banqueproject.entity.Users;
import com.example.banqueproject.service.CommandesService;
import com.example.banqueproject.service.impl.CommandesServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

public class BuyServlet extends HttpServlet {

    private final CommandesService commandesService = new CommandesServiceImpl();

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
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

        int codeArticle = Integer.parseInt(request.getParameter("codeArticle"));
        int qteCde      = Integer.parseInt(request.getParameter("qteCde"));

        // Stock check against session article
        ArticlesDto article = (ArticlesDto) session.getAttribute("selectedArticle");
        if (article != null && (article.getStock() == null || article.getStock() < qteCde)) {
            request.setAttribute("error", "Not enough stock available.");
            request.setAttribute("article", article);
            request.getRequestDispatcher("/cart.jsp").forward(request, response);
            return;
        }

        boolean success = commandesService.passCommande(user.id(), codeArticle, qteCde);

        if (success) {
            response.sendRedirect(request.getContextPath() + "/commandes");
        } else {
            request.setAttribute("error", "Order failed, please try again.");
            request.getRequestDispatcher("/cart.jsp").forward(request, response);
        }
    }
}