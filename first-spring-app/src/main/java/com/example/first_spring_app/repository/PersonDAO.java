package com.example.first_spring_app.repository;


import com.example.first_spring_app.model.Person;
import org.springframework.stereotype.Component;

@Component
public class PersonDAO {

    public Person find() {
        return new Person("Eunice", "Manan", 24);
    }
}
