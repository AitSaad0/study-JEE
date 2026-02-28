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

        String path = request.getRequestURI()
                .substring(request.getContextPath().length());

        // Always allow public paths through
        if (PathLooper.is_public(path)) {
            chain.doFilter(request, response);
            return;
        }

        // Everything else requires authentication
        HttpSession session = request.getSession(false);
        if (session != null && session.getAttribute("user") != null) {
            chain.doFilter(request, response);
            return;
        }

        response.sendRedirect(request.getContextPath() + "/auth");
    }
}