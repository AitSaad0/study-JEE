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
        logger.info("start auth Filter");



        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;

        String email = "";
        String password = "";

        if ("POST".equalsIgnoreCase(req.getMethod())) {

            email = req.getParameter("email");
            password = req.getParameter("password");

            if (isAnyEmpty(email, password) || !isValidEmail(email)) {
                logger.warn("Validation failed for email: {}", email);
                resp.sendRedirect(req.getContextPath() + "/auth.html?error=invalid_data");
                return;
            }

            logger.info("Validation successful for: {}", email);
        }

        String sql = "SELECT full_name, role FROM users WHERE email = ? AND password = ?";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, email);
            pstmt.setString(2, password);

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    req.setAttribute("auth_name", rs.getString("full_name"));
                    req.setAttribute("auth_role", rs.getString("role"));
                    req.setAttribute("auth_email", email);
                }
            }
        } catch (SQLException e) {
            logger.error("Database error during authentication", e);
            resp.sendRedirect(req.getContextPath() + "/auth.html");
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