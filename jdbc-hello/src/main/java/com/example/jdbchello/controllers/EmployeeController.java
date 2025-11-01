package com.example.jdbchello.controllers;


import com.example.jdbchello.models.Employee;
import com.example.jdbchello.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeRepo employeeRepo;

    @GetMapping("/count")
    public int count(){
        return employeeRepo.count();
    }

    @GetMapping("")
    public List<Employee> findAll(){
        return employeeRepo.findAll();
    }

    @GetMapping("/{id}")
    public Employee findById(@PathVariable long id){
        return employeeRepo.findById(id);
    }

    @GetMapping("/del/{id}")
    public void delete(@PathVariable long id){
        employeeRepo.delete(id);
    }
    
}
