package com.example.banqueproject.controller;

import com.example.banqueproject.dto.ArticlesDto;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

public class DetailServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        HttpSession session = request.getSession(false);
        if (session == null) {
            response.sendRedirect(request.getContextPath() + "/auth");
            return;
        }

        String reference = request.getParameter("reference");
        List<ArticlesDto> articles = (List<ArticlesDto>) session.getAttribute("articles"); // ← was "printedArticles"

        if (articles != null && reference != null) {
            for (ArticlesDto article : articles) {
                if (reference.equals(article.getReference())) {
                    request.setAttribute("article", article);
                    break;
                }
            }
        }

        RequestDispatcher rd = request.getRequestDispatcher("/detail.jsp");
        rd.forward(request, response);
    }
}