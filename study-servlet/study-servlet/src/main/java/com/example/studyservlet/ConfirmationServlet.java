package com.example.studyservlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

public class ConfirmationServlet extends HttpServlet {
    public void init() throws ServletException{

    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        HttpSession session = req.getSession(false);
        PrintWriter out = resp.getWriter();
        if(session != null ){
            String name = (String)session.getAttribute("name");
            String email = (String)session.getAttribute("email");
            String age = (String)session.getAttribute("age");
            out.println("<html><body>");
            out.println("<h1> hello " + name + " ur age is " + age + " ur email is " + email  + "</h1>");
            out.println("<h1> peak a boo </h1>");
            out.println("</body></html>");
        }else{
            out.println("<html><body>");
            out.println("<h1>" + "somthing went wrong"  + "</h1>");
            out.println("</body></html>");
        }


    }
}
