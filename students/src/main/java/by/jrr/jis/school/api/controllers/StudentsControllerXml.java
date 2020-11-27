package by.jrr.jis.school.api.controllers;

import by.jrr.jis.school.bean.Student;
import by.jrr.jis.school.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServlet;
import java.util.List;

@RestController
@RequestMapping(value = "/xml-api", produces = {MediaType.APPLICATION_XML_VALUE})
public class StudentsControllerXml extends HttpServlet {

    @Autowired
    StudentService studentService;

    @GetMapping(value = "/students")
    @ResponseBody
    public List<Student> getStudents() {
        return StudentService.findAll();
    }

    @PostMapping(value = "/students")
    public Student addStudent(@RequestBody Student student) {
        return studentService.saveStudentApi(student);
    }

    @GetMapping(value = "/student/{id}")
    public Student getStudentById(@PathVariable int id) {
        return StudentService.findById(id);
    }

    @PutMapping(value = "/student/{id}")
    public Student getStudentById(@PathVariable int id, @RequestBody Student student) {
        return studentService.updateStudentApi(id, student);
    }

    @DeleteMapping(value = "/student/{id}")
    public Student deleteStudentById(@PathVariable int id) {
        return studentService.deleteById(id);
    }
}
