package com.example.jdbchello.models;

public class Employee {

    long id;
    String name;
    Double salary;

    public long getId() {
        return id;
    }

    public Employee(long id, String name, Double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public Employee() {
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }
}
