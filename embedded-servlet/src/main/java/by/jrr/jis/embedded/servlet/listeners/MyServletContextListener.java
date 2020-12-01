package by.jrr.jis.embedded.servlet.listeners;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class MyServletContextListener implements ServletContextListener {


    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        System.out.println("[CONTEXT EVENT]>>>contextInitialized(ServletContextEvent servletContextEvent)");
        //code to initialize the database connection
        //and store it as a context attribute

        String email = servletContextEvent.getServletContext().getInitParameter("bossEmail");
        System.out.println("[CONTEXT EVENT]>>>connecting to database with login " + email);

        servletContextEvent.getServletContext().setAttribute("attributeFromListener", "new Attribute");
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        System.out.println("[CONTEXT EVENT]>>>contextDestroyed(ServletContextEvent servletContextEvent)");
        //code to close the database connection
    }
}
