package ru.geekbrains;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

/*
    URL mapping patterns

    "/something"    ->     "/something"
    "/something/*"  ->     "/something/" or "/something/somethingElse"
    "/*.jpg"        ->     "/something/pic.jpg" or "/pic.jpg"
    ""              ->     application root
    "/"             ->     all application URLs
    "/*"            ->     !!antipattern!!
 */

@WebServlet(name = "FirstHttpServlet", urlPatterns = "/first-http-servlet/*")
public class FirstHttpServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.getWriter().println("<h1>Привет from HttpServlet!!!</h1>");
        resp.getWriter().println("<p>contextPath = " + req.getContextPath() + "</p>");
        resp.getWriter().println("<p>servletPath = " + req.getServletPath() + "</p>");

        // Не очень понимаю, почему когда я после слэша вбиваю какие-то значения он выбрасывает
//      // "Not Found", хотя должен отображать в инфо. Изначально проверял без error-page
        resp.getWriter().println("<p>pathInfo = " + req.getPathInfo() + "</p>");
        resp.getWriter().println("<p>queryString = " + req.getQueryString() + "</p>");

        resp.getWriter().println("<h2>Parameters</h2>");
        req.getParameterMap().forEach(
                (param, value) -> {
                    try {
                        resp.getWriter().println("<p>" + param + " = " + Arrays.toString(value) + "</p>");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
        );

        req.setAttribute("attr", "value");
        getServletContext().getRequestDispatcher("/first-servlet").include(req,resp);
    }
}
