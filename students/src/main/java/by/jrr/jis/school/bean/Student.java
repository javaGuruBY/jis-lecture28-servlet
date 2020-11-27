package by.jrr.jis.school.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@XmlRootElement
@NoArgsConstructor
public class Student {
    public static List<Student> total = new ArrayList<>();

    private Integer id;
    private String name;
    private String lastName;
    private int age;
}
