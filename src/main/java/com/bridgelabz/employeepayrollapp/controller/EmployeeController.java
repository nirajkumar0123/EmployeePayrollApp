package com.bridgelabz.employeepayrollapp.controller;

import com.bridgelabz.employeepayrollapp.model.Employee;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @GetMapping("/welcome")
    public String welcomeMessage() {
        return "Welcome to Employee Payroll App!";
    }

    @PostMapping("/add")
    public Employee addEmployee(@RequestBody Employee employee) {
        return employee;
    }
}


