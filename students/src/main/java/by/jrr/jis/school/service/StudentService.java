package by.jrr.jis.school.service;

import by.jrr.jis.school.bean.Student;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
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

    public static void saveStudent(String name, String lastName, int age) {
        Student student = new Student(Student.total.size(), name, lastName, age);
        Student.total.add(student);
    }

    public List<Student> findAllApi() {
        return Student.total;
    }

    public Student findByIdApi(int id) {
        return Student.total.get(id);
    }

    public void saveStudentApi(Map<String, String[]> params) {

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

    public void saveStudentApi(String name, String lastName, int age) {
        Student student = new Student(Student.total.size(), name, lastName, age);
        Student.total.add(student);
    }

    public Student saveStudentApi(Student student) {
        student.setId(Student.total.size());
        Student.total.add(student);
        return student;
    }

    public Student updateStudentApi(int id, Student student) {
        Student.total.get(id); //todo validate id
        student.setId(id);
        Student.total.add(id, student);
        return student;
    }

    public Student deleteById(int id) {
        Student student = Student.total.get(id); //todo validate id
        Student.total.remove(id);
        return student;
    }
}
