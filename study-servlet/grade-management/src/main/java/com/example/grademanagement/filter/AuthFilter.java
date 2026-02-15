package com.example.grademanagement.filter;

import com.example.grademanagement.config.DBConnection;
import jakarta.mail.internet.AddressException;
import jakarta.mail.internet.InternetAddress;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AuthFilter implements Filter {
    private static final Logger logger = LoggerFactory.getLogger(AuthFilter.class);
    private Connection conn;


    @Override
    public void init(FilterConfig filterConfig) throws ServletException{
        try {
            this.conn = DBConnection.getConnection(filterConfig.getServletContext());
            logger.info("AuthFilter: Connection successful");
        } catch (Exception e) {
            throw new ServletException("Database connection failed in Filter", e);
        }
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;

        // 1. Only run this logic if it's a POST request (Login Attempt)
        if ("POST".equalsIgnoreCase(req.getMethod())) {
            String email = req.getParameter("email");
            String password = req.getParameter("password");

            // Format Validation
            if (isAnyEmpty(email, password) || !isValidEmail(email)) {
                logger.warn("Validation failed for email: {}", email);
                resp.sendRedirect(req.getContextPath() + "/auth.html?error=invalid_data");
                return; // STOP HERE
            }

            // Database Authentication
            String sql = "SELECT full_name, role FROM users WHERE email = ? AND password = ?";
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setString(1, email);
                pstmt.setString(2, password);

                try (ResultSet rs = pstmt.executeQuery()) {
                    if (rs.next()) {
                        // Success: Pass data to the Servlet
                        req.setAttribute("auth_name", rs.getString("full_name"));
                        req.setAttribute("auth_role", rs.getString("role"));
                        req.setAttribute("auth_email", email);

                        // Allow the request to reach AuthServlet
                        chain.doFilter(request, response);
                    } else {
                        // Fail: Wrong credentials
                        logger.warn("Login failed for email: {}", email);
                        resp.sendRedirect(req.getContextPath() + "/auth.html?error=bad_creds");
                        // No chain.doFilter here! We want to stop the request.
                    }
                }
            } catch (SQLException e) {
                logger.error("Database error during authentication", e);
                resp.sendRedirect(req.getContextPath() + "/auth.html?error=db_error");
            }
        } else {
            // 2. It's a GET request (just loading the page) - let it pass to the Servlet/HTML
            chain.doFilter(request, response);
        }
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