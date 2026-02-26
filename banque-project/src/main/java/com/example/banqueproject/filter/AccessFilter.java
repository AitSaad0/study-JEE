package com.example.banqueproject.filter;

import com.example.banqueproject.config.PathLooper;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
public class AccessFilter implements Filter {

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;

        HttpSession session = request.getSession(false);
        String path = request.getRequestURI();

        // Public resources
        if (PathLooper.is_public(path)) {
            chain.doFilter(request, response);
            return;
        }

        // Private + authenticated
        if (session != null && session.getAttribute("user") != null) {
            chain.doFilter(request, response);
            return;
        }

        // Not authenticated
        response.sendRedirect(request.getContextPath() + "/auth");
    }
}