package com.example.grademanagement.filter;

import jakarta.mail.internet.AddressException;
import jakarta.mail.internet.InternetAddress;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class RegisterFilter implements Filter{
    private static final Logger logger = LoggerFactory.getLogger(RegisterFilter.class.getName());
    public void doFilter  (
            ServletRequest request,
            ServletResponse response,
            FilterChain chain
    ) throws IOException, ServletException {

        logger.info("start register Filter");


        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;

        if ("POST".equalsIgnoreCase(req.getMethod())) {
            String fullName = req.getParameter("full_name");
            String email = req.getParameter("email");
            String role = req.getParameter("role");
            String password = req.getParameter("password");
            String confirm_password = req.getParameter("confirm_password");

            if(fullName.isEmpty()){
                logger.warn("full name is empty");
                resp.sendRedirect(req.getContextPath() + "/register.html");
                return;
            }
            if(email.isEmpty()){
                logger.warn("email is empty");
                resp.sendRedirect(req.getContextPath() + "/register.html");
                return;
            }
            if(role.isEmpty()){
                logger.warn("role is empty");
                resp.sendRedirect(req.getContextPath() + "/register.html");
                return;
            }
            if(password.isEmpty()){
                logger.warn("password is empty");
                resp.sendRedirect(req.getContextPath() + "/register.html");
                return;
            }
            if(confirm_password.isEmpty()){
                logger.warn("confirm_password is empty");
                resp.sendRedirect(req.getContextPath() + "/register.html");
                return;
            }
            if(!password.equals(confirm_password)){
                logger.warn("confirm message is different from the password");
                resp.sendRedirect(req.getContextPath() + "/register.html");
                return;
            }

            if (!isValidEmail(email)) {
                logger.warn("Invalid email attempt: {}", email);
                resp.sendRedirect("register.html");
                return;
            }
        }



        chain.doFilter(request, response);
        logger.info("we are the end of the register filter");

    }

    private boolean isValidEmail(String email) {
        if (email == null) return false;
        try {
            InternetAddress emailAddr = new InternetAddress(email);
            emailAddr.validate();
            return true;
        } catch (AddressException ex) {
            return false;
        }
    }
}
