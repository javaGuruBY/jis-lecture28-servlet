package by.jrr.jis;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Person {
    public String name;
    private Dog dog;
    private List<Dog> hostelDogs = new ArrayList<>();
}
