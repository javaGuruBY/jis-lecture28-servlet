package by.jrr.jis.school.controllers;

import by.jrr.jis.school.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpServlet;

@Controller
public class StudentCard extends HttpServlet {

    @GetMapping("/student/{id}")
    protected String doGet(Model model, @PathVariable int id){
        model.addAttribute("student", StudentService.findById(id));
        model.addAttribute("message", "Hello from spring MVC");
        return "studentCard";
    }
}
