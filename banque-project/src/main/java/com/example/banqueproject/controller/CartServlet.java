package com.example.banqueproject.controller;

import com.example.banqueproject.dto.ArticlesDto;
import com.example.banqueproject.dto.UserDto;
import com.example.banqueproject.entity.Users;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

public class CartServlet extends HttpServlet {

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

        String reference = request.getParameter("id");
        if (reference == null || reference.isEmpty()) {
            response.sendRedirect(request.getContextPath() + "/catalogue");
            return;
        }

        // Find article from session — no DB call
        List<ArticlesDto> articles = (List<ArticlesDto>) session.getAttribute("articles");
        ArticlesDto selectedArticle = null;

        if (articles != null) {
            for (ArticlesDto article : articles) {
                if (reference.equals(article.getReference())) {
                    selectedArticle = article;
                    break;
                }
            }
        }

        if (selectedArticle == null) {
            response.sendRedirect(request.getContextPath() + "/catalogue");
            return;
        }

        // Just put article in request scope for cart.jsp to display
        request.setAttribute("article", selectedArticle);
        request.getRequestDispatcher("/cart.jsp").forward(request, response);
    }
}