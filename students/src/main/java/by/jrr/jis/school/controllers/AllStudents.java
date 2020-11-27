package by.jrr.jis.school.controllers;

import by.jrr.jis.school.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import java.io.IOException;

@Controller
public class AllStudents extends HttpServlet {

    @GetMapping("/students")
    public String doGet(Model model) throws IOException, ServletException {
        model.addAttribute("studentList", StudentService.findAll());
        model.addAttribute("studentsTotal", StudentService.findAll().size());
        model.addAttribute("message", "Hello from spring MVC");

        return "allStudents";
    }
}
