package com.example.first_spring_app.model;

public class Person {
    private String firstName;
    private String lastName;
    private int age;

    public Person(String firstname, String lastName, int age) {
        this.firstName = firstname;
        this.lastName = lastName;
        this.age = age;
    }
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Person{");
        sb.append("firstName='").append(firstName).append('\'');
        sb.append(", lastName='").append(lastName).append('\'');
        sb.append(", age=").append(age);
        sb.append('}');
        return sb.toString();
    }
}
