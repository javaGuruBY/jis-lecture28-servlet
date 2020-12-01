package by.jrr.jis.embedded.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

public class WelkomeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = (String) req.getSession().getAttribute("name");
        Cookie[] cookies = req.getCookies();
        for(Cookie cookie : cookies) {
            if(cookie.getName().equals("login")) {
                req.setAttribute("login", cookie.getValue());
            }
        }

        RequestDispatcher view = req.getRequestDispatcher("/welcome.jsp");
        view.forward(req, resp);

    }
}
