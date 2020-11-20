package by.jrr.jis.jis5servlet.myservlets;

import by.jrr.jis.jis5servlet.bean.Student;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

public class AddStudent extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter out = response.getWriter();

        out.println(
                "<!DOCTYPE html>\n" +
                        "<html lang=\"en\">\n" +
                        "<head>\n" +
                        "    <meta charset=\"UTF-8\">\n" +
                        "    <title>timer</title>\n" +
                        "</head>\n" +
                        "<body align=\"center\">\n" +
                        "<h1> time is passing </h1>\n" +
                        "<form method=\"post\" >\n" +
                        "    <input name=\"name\" placeholder=\"name\" type=\"text\"/> <br />\n" +
                        "    <input name=\"lastName\" placeholder=\"lastName\" type=\"text\"/> <br />\n" +
                        "    <input name=\"age\" placeholder=\"age\" type=\"text\"/> <br />\n" +
                        "    <input type=\"submit\" value=\"save\">\n" +
                        "</form>\n" +
                        "</body>\n" +
                        "</html>"
        );
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String lastName = req.getParameter("lastName");
        int age = 0;
        try {
            age = Integer.valueOf(req.getParameter("age"));
        } catch (Exception ex) {
        }

        Student student = new Student(Student.total.size(), name, lastName, age);
        Student.total.add(student);
        resp.sendRedirect("/school/students");
    }
}
