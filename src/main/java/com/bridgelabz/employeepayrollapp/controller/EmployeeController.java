package com.bridgelabz.employeepayrollapp.controller;

import com.bridgelabz.employeepayrollapp.model.Employee;
import com.bridgelabz.employeepayrollapp.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    // GET Request - Retrieve All Employees
    @GetMapping("/all")
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    // GET Request - Retrieve Employee by ID
    @GetMapping("/{id}")
    public Optional<Employee> getEmployeeById(@PathVariable Long id) {
        return employeeRepository.findById(id);
    }

    // POST Request - Add a New Employee
    @PostMapping("/add")
    public Employee addEmployee(@RequestBody Employee employee) {
        return employeeRepository.save(employee);
    }

    // PUT Request - Update Employee
    @PutMapping("/update/{id}")
    public Employee updateEmployee(@PathVariable Long id, @RequestBody Employee updatedEmployee) {
        return employeeRepository.findById(id)
                .map(employee -> {
                    employee.setName(updatedEmployee.getName());
                    employee.setSalary(updatedEmployee.getSalary());
                    return employeeRepository.save(employee);
                })
                .orElseThrow(() -> new RuntimeException("Employee not found with id: " + id));
    }

    // DELETE Request - Delete Employee
    @DeleteMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable Long id) {
        employeeRepository.deleteById(id);
        return "Employee deleted with ID: " + id;
    }
}



