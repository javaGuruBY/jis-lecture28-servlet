package by.jrr.jis.school.controllers;

import by.jrr.jis.school.service.StudentService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class StudentCard extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.valueOf(req.getParameter("id"));

        req.setAttribute("student", StudentService.findById(id));

        RequestDispatcher view = req.getRequestDispatcher("/studentCard.jsp");
        view.forward(req, resp);

    }
}
