package com.example.studyservlet;

import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

public class InformationServlet extends HttpServlet {

    public void init() throws ServletException{

    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");

        String name = req.getParameter("name");
        String age = req.getParameter("age");
        String email = req.getParameter("email");

        HttpSession session = req.getSession();

        session.setAttribute("name", name);
        session.setAttribute("age", age);
        session.setAttribute("email", email);

        String url = resp.encodeURL(req.getContextPath() + "/confirmation");
        PrintWriter out = resp.getWriter();
        out.println("<html><body>");
        out.println("<h1> hello " + (String)session.getAttribute("name") + " ur age is " + (String)session.getAttribute("age") + " ur email is " + (String)session.getAttribute("email") + "</h1>");
        out.println("<h1>" + "do u confirm this infos " + "</h1>");
        out.println("<a href=\" " + url +"\"> confirmer /a>");
        out.println("</body></html>");

    }

    @Override
    public void destroy() {
    }
}
