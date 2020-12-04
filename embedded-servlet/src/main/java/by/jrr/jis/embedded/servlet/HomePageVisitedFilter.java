package by.jrr.jis.embedded.servlet;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class HomePageVisitedFilter implements Filter {
    private FilterConfig fc;

    @Override
    public void init(final FilterConfig filterConfig) throws ServletException {
        this.fc = filterConfig;
    }

    @Override
    public void doFilter(ServletRequest request,
                         ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        Boolean isHomePageVisited = (boolean) req.getSession().getAttribute("homePageVisited");
        if(isHomePageVisited != null && isHomePageVisited == true) {
            chain.doFilter(request, response);
        } else {
            RequestDispatcher view = req.getRequestDispatcher("/error.jsp");
            view.forward(request, response);
        }
    }

    @Override
    public void destroy() {

    }
}
