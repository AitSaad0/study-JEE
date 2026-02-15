package com.example.grademanagement.filter;

import jakarta.mail.internet.AddressException;
import jakarta.mail.internet.InternetAddress;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
public class AuthFilter implements Filter {
    private static final Logger logger = LoggerFactory.getLogger(AuthFilter.class);

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        logger.info("start auth Filter");


        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;

        if ("POST".equalsIgnoreCase(req.getMethod())) {

            String email = req.getParameter("email");
            String role = req.getParameter("role");
            String password = req.getParameter("password");

            if (isAnyEmpty(email, role, password) || !isValidEmail(email)) {
                logger.warn("Validation failed for email: {}", email);
                resp.sendRedirect(req.getContextPath() + "/auth.html?error=invalid_data");
                return;
            }

            logger.info("Validation successful for: {}", email);
        }

        chain.doFilter(request, response);
        logger.info("we are the end of the auth filter");

    }
    private boolean isAnyEmpty(String... fields) {
        for (String field : fields) {
            if (field == null || field.trim().isEmpty()) return true;
        }
        return false;
    }

    private boolean isValidEmail(String email) {
        if (email == null) return false;
        try {
            new InternetAddress(email).validate();
            return true;
        } catch (AddressException ex) {
            return false;
        }
    }
}