package com.example.banqueproject.controller;

import com.example.banqueproject.dto.UserDto;
import com.example.banqueproject.dto.mapper.UserMapper;
import com.example.banqueproject.entity.Users;
import com.example.banqueproject.service.UserService;
import com.example.banqueproject.service.impl.UserServiceImpl;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

public class AuthServlet extends HttpServlet {

    private UserService userService = new UserServiceImpl();

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        RequestDispatcher rd = request.getRequestDispatcher("/auth.jsp");
        rd.forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        response.setContentType("text/html");
        HttpSession session = request.getSession(true);

        String email = request.getParameter("email");
        String password = request.getParameter("password");

        Users user = userService.authenticate(email, password);

        if (user == null) {
            request.setAttribute("errorMessage", "Credential error");
            request.getRequestDispatcher("/auth.jsp").forward(request, response);
            return;
        }

        UserDto userDto = UserMapper.clientToCLientDto(user);
        session.setAttribute("user", userDto);

        response.sendRedirect(request.getContextPath() + "/dashboard");
    }
}
