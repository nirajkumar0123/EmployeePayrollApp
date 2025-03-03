package com.bridgelabz.employeepayrollapp.controller;

import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDTO;
import com.bridgelabz.employeepayrollapp.model.Employee;
import com.bridgelabz.employeepayrollapp.service.EmployeePayrollService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeePayrollService employeePayrollService;

    // Get all employees
    @GetMapping("/all")
    public List<Employee> getAllEmployees() {
        return employeePayrollService.getAllEmployees();
    }

    // Get Employee by ID
    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable Long id) {
        return employeePayrollService.getEmployeeById(id);
    }

    // Update Employee
    @PutMapping("/update/{id}")
    public Employee updateEmployee(@PathVariable Long id, @Valid @RequestBody EmployeePayrollDTO employeeDTO) {
        return employeePayrollService.updateEmployee(id, employeeDTO);
    }

    // Delete Employee
    @DeleteMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable Long id) {
        employeePayrollService.deleteEmployee(id);
        return "Employee with ID " + id + " deleted successfully.";
      
    // Add Employee
    @PostMapping("/add")
    public Employee addEmployee(@Valid @RequestBody EmployeePayrollDTO employeeDTO) {
        return employeePayrollService.addEmployee(employeeDTO);
    }
}
