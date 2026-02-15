package com.example.grademanagement.controller;

import com.example.grademanagement.config.DBConnection;
import com.example.grademanagement.dashboard.StudentDashboard;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.sql.Connection;

public class AuthServlet extends HttpServlet {

    private Connection conn;
    private static final Logger logger = LoggerFactory.getLogger(AuthServlet.class.getName());



    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.info("we are at auth servlet");
        String name = (String) req.getAttribute("auth_name");
        String role = (String) req.getAttribute("auth_role");
        String email = (String) req.getAttribute("auth_email");

        logger.info("the request method is {} ", req.getMethod());


        if ("student".equalsIgnoreCase(role)) {
            HttpSession session = req.getSession();
            session.setAttribute("name", name);
            session.setAttribute("email", email);
            session.setAttribute("role", role);
            String dashboardUrl = resp.encodeRedirectURL(req.getContextPath() + "/student_dashboard");
            resp.sendRedirect(dashboardUrl);
        } else if ("prof".equalsIgnoreCase(role)) {
            resp.sendRedirect(req.getContextPath() + "/prof_dashboard");
        } else {
            req.getRequestDispatcher("/WEB-INF/auth.html").forward(req, resp);
        }
        logger.info("we are at the end of auth servlet");

    }
}