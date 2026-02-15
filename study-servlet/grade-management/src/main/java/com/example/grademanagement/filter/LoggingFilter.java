package com.example.grademanagement.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;
import java.util.logging.Logger;

public class LoggingFilter implements Filter {
    private static final Logger logger = Logger.getLogger(LoggingFilter.class.getName());

    public void doFilter(
            ServletRequest request,
            ServletResponse response,
            FilterChain chain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;

        logger.info(
                "Request in" +
                        req.getMethod() + " " +
                        req.getRequestURI()
        );

        chain.doFilter(request, response);

        logger.info("REQUEST END → " +
                req.getRequestURI());

    }
}
