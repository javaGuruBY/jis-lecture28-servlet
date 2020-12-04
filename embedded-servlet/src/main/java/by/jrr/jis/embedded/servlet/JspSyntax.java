package by.jrr.jis.embedded.servlet;

import by.jrr.jis.Dog;
import by.jrr.jis.Person;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JspSyntax extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Dog dog = new Dog();
        dog.setName("DogName");
        Person person = new Person();
        person.setName("personName");
        person.setDog(dog);
        person.setHostelDogs(getDogs());

        req.setAttribute("person", person);

        RequestDispatcher view = req.getRequestDispatcher("/jsp.jsp");
        view.forward(req, resp);

    }

    private List<Dog> getDogs() {
        List<Dog> dogs = new ArrayList<>();
        for(int i = 0; i < 5; i++) {
            Dog dog = new Dog();
            dog.setName("DogName " + i);
            dog.setAge(i + 10);
            dogs.add(dog);
        }
        return dogs;
    }
}
