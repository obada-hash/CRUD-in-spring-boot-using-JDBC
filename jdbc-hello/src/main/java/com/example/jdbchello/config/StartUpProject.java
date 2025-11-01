package com.example.jdbchello.config;

import com.example.jdbchello.models.Employee;
import com.example.jdbchello.repository.impl.EmployeeJDBCRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class StartUpProject implements CommandLineRunner {
    @Autowired
    private EmployeeJDBCRepo repo;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void run(String... args) throws Exception {

        jdbcTemplate.execute("DROP TABLE IF EXISTS employees");
        jdbcTemplate.execute("CREATE TABLE employees (ID INT PRIMARY KEY AUTO_INCREMENT, NAME VARCHAR(255), SALARY NUMERIC(15, 2))");
        if(repo.count() == 0) {
            repo.insert(new Employee(1, "Obada", 633.3));
            repo.insert(new Employee(33, "motaz", 65.3));
            repo.insert(new Employee(34, "Hiba", 655.3));
            repo.insert(new Employee(35, "Mahmoud", 64.3));
        }

    }
}
