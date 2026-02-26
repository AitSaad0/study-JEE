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

public class RegisterServlet extends HttpServlet {

    private UserService userService = new UserServiceImpl();

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        RequestDispatcher rd = request.getRequestDispatcher("/register.jsp");
        rd.forward(request, response);
    }


    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        HttpSession session = request.getSession();
        String email = request.getParameter("email");
        String name = request.getParameter("name");
        String address = request.getParameter("address");
        String zip = request.getParameter("zip");
        String city = request.getParameter("city");
        String tel = request.getParameter("tel");
        String password = request.getParameter("password");

        Users client = new Users(email, name, address, zip, city, tel, password);
        boolean result = userService.register(client);
        UserDto userDto = UserMapper.clientToCLientDto(client);
        if(result){
            session.setAttribute("user", userDto);
            System.out.println(userDto.name());
            RequestDispatcher rd = request.getRequestDispatcher("/dashboard.jsp");
            rd.forward(request, response);
        }else{
            request.setAttribute("errorMessage", "user already exist");
            RequestDispatcher rd = request.getRequestDispatcher("/register.jsp");
            rd.forward(request, response);
        }
    }
}
