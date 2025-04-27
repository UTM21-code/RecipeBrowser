package com.example.demo;

import java.util.LinkedList;

public class PersonDB_Mem implements IPersonDB {

    private final LinkedList<Person> db;

    public PersonDB_Mem() {
        this.db = new LinkedList<>();
    }

    @Override
    public void addPerson( Person p ) {
        db.add(p);
    }

    @Override
    public int numInDB() {
        return db.size();
    }
    @Override
    public boolean containsPersonWithName(String name) {
        for (Person p : db) {
            if (p.name.equals(name)) {
                return true;
            }
        }
        return false;
    }

}