package com.example.banqueproject.controller;

import com.example.banqueproject.dto.PrintedArticleDto;
import com.example.banqueproject.entity.Categories;
import com.example.banqueproject.service.ArticlesService;
import com.example.banqueproject.service.CategoriesService;
import com.example.banqueproject.service.impl.ArticlesServiceImpl;
import com.example.banqueproject.service.impl.CategoriesServiceImpl;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;

public class CatalogueServlet extends HttpServlet {
    private CategoriesService categoriesService = new CategoriesServiceImpl();
    private ArticlesService articlesService = new ArticlesServiceImpl();


    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        response.setContentType("text/html]");
        HttpSession session = request.getSession(false);
        String idCatStr = request.getParameter("category");


        if(session != null){
            List<Categories> categories = categoriesService.getAllCategories();
            session.setAttribute("categories", categories);
            List<PrintedArticleDto> printedArticles;
            try {
                if (idCatStr != null && !idCatStr.isEmpty() && !idCatStr.equalsIgnoreCase("all")) {
                    int idCat = Integer.parseInt(idCatStr);
                    printedArticles = articlesService.getAllArticlesByCategory(idCat);
                } else {
                    printedArticles = articlesService.getAllArticles();
                }

                session.setAttribute("printedArticles", printedArticles);

            } catch (NoSuchElementException e) {
                RequestDispatcher rd = request.getRequestDispatcher("/catalogue.jsp?category=all");
                rd.forward(request, response);
                return;
            }


            RequestDispatcher rd = request.getRequestDispatcher("/catalogue.jsp");
            rd.forward(request, response);

        }
       }
}
