package com.example.grademanagement.filter;

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

        logger.info("start credential Filter");


        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;

        String path = req.getRequestURI();

        logger.info("the path is {}", path);

        if(path.endsWith("register.html")){
            String password = req.getParameter("password");
            String confirm_password = req.getParameter("confirm_password");
            logger.info("password : {} , confirm password : {}", password , confirm_password);
            if(!password.equals(confirm_password) || password.isEmpty() || confirm_password.isEmpty()){
                try{
                    resp.sendRedirect(req.getRequestURI() + "/index.html");
                }catch (IOException e){
                    System.out.println("redirection failed");
                }
            }



        }
        chain.doFilter(request, response);
        logger.info("we are the end of the Credential filter");

    }
}
