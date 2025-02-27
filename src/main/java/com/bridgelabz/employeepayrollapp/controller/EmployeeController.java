package com.bridgelabz.employeepayrollapp.controller;

import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDTO;
import com.bridgelabz.employeepayrollapp.model.Employee;
import com.bridgelabz.employeepayrollapp.service.EmployeePayrollService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeePayrollService employeeService;

    // GET Request - Retrieve All Employees
    @GetMapping("/all")
    public List<Employee> getAllEmployees() {
        log.info("GET /all - Retrieving all employees");
        return employeeService.getAllEmployees();
    }

    // GET Request - Retrieve Employee by ID
    @GetMapping("/{id}")
    public Optional<Employee> getEmployeeById(@PathVariable Long id) {
        log.info("GET /{} - Retrieving employee", id);
        return employeeService.getEmployeeById(id);
    }

    // POST Request - Add a New Employee (Use DTO)
    @PostMapping("/add")
    public Employee addEmployee(@Valid @RequestBody EmployeePayrollDTO employeeDTO) {
        log.info("POST /add - Adding employee: {}", employeeDTO);
        return employeeService.addEmployee(employeeDTO);

    }


    // PUT Request - Update Employee (Use DTO)
    @PutMapping("/update/{id}")
    public Employee updateEmployee(@PathVariable Long id, @Valid @RequestBody EmployeePayrollDTO employeeDTO) {
        log.info("PUT /update/{} - Updating employee", id);
        return employeeService.updateEmployee(id, employeeDTO);
    }


    // DELETE Request - Delete Employee
    @DeleteMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable Long id) {
        log.warn("DELETE /delete/{} - Deleting employee", id);
        employeeService.deleteEmployee(id);
        return "Employee deleted with ID: " + id;
    }
}



