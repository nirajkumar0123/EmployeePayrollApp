package com.bridgelabz.employeepayrollapp.controller;

import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDTO;
import com.bridgelabz.employeepayrollapp.model.Employee;
import com.bridgelabz.employeepayrollapp.service.EmployeePayrollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeePayrollService employeeService;

    // GET Request - Retrieve All Employees
    @GetMapping("/all")
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    // GET Request - Retrieve Employee by ID
    @GetMapping("/{id}")
    public Optional<Employee> getEmployeeById(@PathVariable Long id) {
        return employeeService.getEmployeeById(id);
    }

    // POST Request - Add a New Employee (Use DTO)
    @PostMapping("/add")
    public Employee addEmployee(@RequestBody EmployeePayrollDTO employeeDTO) {
        return employeeService.addEmployee(employeeDTO);

    }


    // PUT Request - Update Employee (Use DTO)
    @PutMapping("/update/{id}")
    public Employee updateEmployee(@PathVariable Long id, @RequestBody EmployeePayrollDTO employeeDTO) {
        return employeeService.updateEmployee(id, employeeDTO);
    }


    // DELETE Request - Delete Employee
    @DeleteMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
        return "Employee deleted with ID: " + id;
    }
}



