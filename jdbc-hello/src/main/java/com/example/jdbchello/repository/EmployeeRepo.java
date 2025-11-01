package com.example.jdbchello.repository;

import com.example.jdbchello.models.Employee;

import java.util.List;

public interface EmployeeRepo {

    int count ();
    Employee findById(long id);
    List<Employee> findAll();
    int insert(Employee employee);
    int update(Employee employee);
    int delete(long id);

}
