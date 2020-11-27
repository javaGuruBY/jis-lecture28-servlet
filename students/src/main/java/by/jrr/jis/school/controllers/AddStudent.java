package by.jrr.jis.school.controllers;

import by.jrr.jis.school.service.StudentService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServlet;

@Controller
public class AddStudent extends HttpServlet {

    @GetMapping("/students/add")
    public String doGet(Model model){
        model.addAttribute("message", "Hello from spring MVC");
        return "studentForm";
    }

    @PostMapping("/students/add")
    protected String doPost(@RequestParam String name,
                          @RequestParam String lastName,
                          @RequestParam int age) {
        StudentService.saveStudent(name, lastName, age);
        return "redirect: /school/students";
    }
}
