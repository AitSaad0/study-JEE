package com.example.grademanagement.controller;

import com.example.grademanagement.dashboard.StudentDashboard;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
public class AuthServlet extends HttpServlet {

    private static final Logger logger = LoggerFactory.getLogger(AuthServlet.class.getName());


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.info("we are at auth servlet");
        String email = req.getParameter("email");
        String role = req.getParameter("role");

        logger.info("the request method is {} ", req.getMethod());

        if ("student".equalsIgnoreCase(role)) {
            resp.sendRedirect(req.getContextPath() + "/student_dashboard");
        } else if ("prof".equalsIgnoreCase(role)) {
            resp.sendRedirect(req.getContextPath() + "/prof_dashboard");
        } else {
            req.getRequestDispatcher("/WEB-INF/auth.html").forward(req, resp);
        }
        logger.info("we are at the end of auth servlet");

    }
}