package com.example.demo;

public interface IPersonDB {
    void addPerson( Person p );
    int numInDB();
    boolean containsPersonWithName(String name);
}
