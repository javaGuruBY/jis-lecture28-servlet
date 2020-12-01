package by.jrr.jis.embedded.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;

public class HomeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = getServletContext().getInitParameter("bossEmail");

        req.setAttribute("message", "@Bax Hello from My servlet");
        req.setAttribute("email", email);
        req.setAttribute("bossEmail", email);


        sessionSyntax(req);
        cookieSyntax(req, resp);


        RequestDispatcher view = req.getRequestDispatcher("/home.jsp");
        view.forward(req, resp);

    }

    //on server side
    private void sessionSyntax(HttpServletRequest req) {
        //session hijacking
        //jsessionis=

        HttpSession session = req.getSession(); //create session if not exist
        System.out.println("[SESSION]>>>>session.isNew() = " + session.isNew());

        if (session.isNew()) {
            String name = req.getParameter("name");
            session.setAttribute("name", name);
            req.setAttribute("name", name);
        } else {
            String name = (String) req.getSession().getAttribute("name");
            req.setAttribute("name", name);
        }

        HttpSession sessionIfIsInCookie = req.getSession(false); //not create session if not in cookie

        session.getCreationTime();
        session.getLastAccessedTime();
        session.getMaxInactiveInterval();
        session.setMaxInactiveInterval(36000);
//        session.invalidate();

    }

    //on user side
    private void cookieSyntax(HttpServletRequest req, HttpServletResponse resp) {

        Cookie loginCookie = new Cookie("login", "userdev");
        loginCookie.setMaxAge(30*60);
        resp.addCookie(loginCookie);

        Cookie[] cookies = req.getCookies();
    }
}
