package com.example.demo;

public class Person { // Model - part of the model...
    String name;
    Integer age;
    String lastName;

    // Without setters this doesn't make much sense to allow
    // the use.
    private Person() {
        this.name = "Unknown";
        this.lastName = "Unknown";
        this.age = 0;
    }

    Person(String name,String lastName, Integer age) {
        this.name = name;
        this.lastName = lastName;
        this.age = age;
    }
}
