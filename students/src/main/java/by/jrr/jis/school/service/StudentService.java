package by.jrr.jis.school.service;

import by.jrr.jis.school.bean.Student;
import by.jrr.jis.school.bean.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class StudentService {

    public static List<Student> findAll() {
        return StudentRepository.total;
    }

    public static Student findById(int id) {
        return StudentRepository.total.get(id);
    }

    public static void saveStudent(Map<String, String[]> params) {

        String name = params.get("name")[0];
        String lastName = params.get("lastName")[0];
        int age = 0;
        try {
            age = Integer.valueOf(params.get("age")[0]);
        } catch (Exception ex) {
        }

        Student student = new Student(StudentRepository.total.size(), name, lastName, age);
        StudentRepository.total.add(student);
    }

    public static void saveStudent(String name, String lastName, int age) {
        Student student = new Student(StudentRepository.total.size(), name, lastName, age);
        StudentRepository.total.add(student);
    }

    public List<Student> findAllApi() {
        return StudentRepository.total;
    }

    public Student findByIdApi(int id) {
        return StudentRepository.total.get(id);
    }

    public void saveStudentApi(Map<String, String[]> params) {

        String name = params.get("name")[0];
        String lastName = params.get("lastName")[0];
        int age = 0;
        try {
            age = Integer.valueOf(params.get("age")[0]);
        } catch (Exception ex) {
        }

        Student student = new Student(StudentRepository.total.size(), name, lastName, age);
        StudentRepository.total.add(student);
    }

    public void saveStudentApi(String name, String lastName, int age) {
        Student student = new Student(StudentRepository.total.size(), name, lastName, age);
        StudentRepository.total.add(student);
    }

    public Student saveStudentApi(Student student) {
        student.setId(StudentRepository.total.size());
        StudentRepository.total.add(student);
        return student;
    }

    public Student updateStudentApi(int id, Student student) {
        StudentRepository.total.get(id); //todo validate id
        student.setId(id);
        StudentRepository.total.add(id, student);
        return student;
    }

    public Student deleteById(int id) {
        Student student = StudentRepository.total.get(id); //todo validate id
        StudentRepository.total.remove(id);
        return student;
    }
}
