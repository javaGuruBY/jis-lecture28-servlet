package by.jrr.jis.jis5servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

public class MyServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        LocalDateTime now = LocalDateTime.now();

        out.println("<html>");
        out.println("<body>");
        out.println("<h1 align=center> The simplest servlet</h1>" );
        out.println("<p align=center><b> " + now + "</b></p>");
        out.println("</body>");
        out.println("</body>");
    }
}
