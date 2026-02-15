package com.example.grademanagement.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;


public class LoggingFilter implements Filter {
    private static final Logger logger = LoggerFactory.getLogger(LoggingFilter.class.getName());

    public void doFilter(
            ServletRequest request,
            ServletResponse response,
            FilterChain chain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;

        logger.info("Request in{} {}", req.getMethod(), req.getRequestURI());

        chain.doFilter(request, response);

        logger.info("REQUEST END → {}", req.getRequestURI());

    }
}
