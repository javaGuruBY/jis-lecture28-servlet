package by.jrr.jis.jis5servlet.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
public class Student {
    public static List<Student> total = new ArrayList<>();

    private Integer id;
    private String name;
    private String lastName;
    private int age;
}
