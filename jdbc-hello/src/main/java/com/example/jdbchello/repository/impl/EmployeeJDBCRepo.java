package com.example.jdbchello.repository.impl;

import com.example.jdbchello.mapper.EmployeeMapper;
import com.example.jdbchello.models.Employee;
import com.example.jdbchello.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EmployeeJDBCRepo implements EmployeeRepo {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Override
    public int count() {
        return jdbcTemplate.queryForObject("select count(*) from employees", Integer.class);
    }

    @Override
    public Employee findById(long id) {
        return jdbcTemplate.queryForObject("select id, name, salary from employees where id = ?",
                new Object[]{id},
                new EmployeeMapper());
    }

    @Override
    public List<Employee> findAll() {
        return jdbcTemplate.query("select id, name, salary from employees", new EmployeeMapper());
    }

    @Override
    public int insert(Employee employee) {
        return jdbcTemplate.update("insert into employees(id, name, salary) values(?, ?, ?)",
                new Object[]{employee.getId(), employee.getName(), employee.getSalary()});
    }

    @Override
    public int update(Employee employee) {
        return jdbcTemplate.update("update employees set name=? , salary=? where id=?",
                new Object[]{employee.getName(), employee.getSalary(), employee.getId()});
    }

    @Override
    public int delete(long id) {
        return jdbcTemplate.update("delete from employees where id = ?", new Object[]{id});
    }
}
