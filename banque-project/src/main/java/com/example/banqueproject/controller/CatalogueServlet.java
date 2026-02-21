package com.example.banqueproject.controller;

import com.example.banqueproject.entity.Categories;
import com.example.banqueproject.service.CategoriesService;
import com.example.banqueproject.service.impl.CategoriesServiceImpl;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

public class CatalogueServlet extends HttpServlet {
    private CategoriesService categoriesService = new CategoriesServiceImpl();


    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        response.setContentType("text/html]");
        HttpSession session = request.getSession(false);
        if(session != null){
            List<Categories> categories = categoriesService.getAllCategories();
            session.setAttribute("categories", categories);
            RequestDispatcher rd = request.getRequestDispatcher("/catalogue.jsp");
            rd.forward(request, response);

        }
       }
}
