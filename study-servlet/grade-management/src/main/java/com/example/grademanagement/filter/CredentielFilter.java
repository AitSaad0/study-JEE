package com.example.grademanagement.filter;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class CredentielFilter implements Filter{

    public void doFilter (
            ServletRequest request,
            ServletResponse response,
            FilterChain chain
    ){

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;

        String path = req.getRequestURI();

        if(path.endsWith("register.html")){
            String password = req.getParameter("password");
            String confirm_password = req.getParameter("confirm_password");
            System.out.println("password : " + password + ", confirm password : " + confirm_password);
            if(!password.equals(confirm_password) || password.isEmpty() || confirm_password.isEmpty()){
                try{
                    resp.sendRedirect(req.getRequestURI() + "/index.html");
                }catch (IOException e){
                    System.out.println("redirection faild");
                }
            }


        }
    }
}
