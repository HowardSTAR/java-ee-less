package ru.geekbrains;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "HeaderServlet", urlPatterns = "/manu")
public class MenuServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().println("<a href = /firstapp/first-servlet/main-page> Main </a>");
        resp.getWriter().println("<a href = /firstapp/first-servlet/cart> Cart </a>");
        resp.getWriter().println("<a href = /firstapp/first-servlet/order> Order </a>");
        resp.getWriter().println("<a href = /firstapp/first-servlet/catalog> Catalog </a>");
    }
}
