package by.jrr.jis.school.controllers;

import by.jrr.jis.school.service.StudentService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AllStudents extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setAttribute("studentList", StudentService.findAll());
        request.setAttribute("studentsTotal", StudentService.findAll().size());

        RequestDispatcher view = request.getRequestDispatcher("allStudents.jsp");

        view.forward(request, response);
    }
}
