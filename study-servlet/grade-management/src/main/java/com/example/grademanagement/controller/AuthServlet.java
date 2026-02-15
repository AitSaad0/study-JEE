package com.example.grademanagement.controller;

import com.example.grademanagement.dashboard.StudentDashboard;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
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
            HttpSession session = req.getSession();
            session.setAttribute("full_name", "saad");
            session.setAttribute("email", email);
            session.setAttribute("role", role);
            session.setAttribute("password", req.getParameter("password"));
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