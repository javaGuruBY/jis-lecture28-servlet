package by.jrr.jis.school.service;

import by.jrr.jis.school.bean.Student;

import java.util.List;
import java.util.Map;

public class StudentService {

    public static List<Student> findAll() {
        return Student.total;
    }

    public static Student findById(int id) {
        return Student.total.get(id);
    }

    public static void saveStudent(Map<String, String[]> params) {

        String name = params.get("name")[0];
        String lastName = params.get("lastName")[0];
        int age = 0;
        try {
            age = Integer.valueOf(params.get("age")[0]);
        } catch (Exception ex) {
        }

        Student student = new Student(Student.total.size(), name, lastName, age);
        Student.total.add(student);
    }
}
