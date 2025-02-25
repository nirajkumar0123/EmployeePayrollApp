package com.bridgelabz.employeepayrollapp.controller;

import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDTO;
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

    // POST Request - Add a New Employee (Use DTO)
    @PostMapping("/add")
    public EmployeePayrollDTO addEmployee(@RequestBody EmployeePayrollDTO employeeDTO) {
        Employee employee = new Employee(employeeDTO.getName(), employeeDTO.getSalary());
        employeeRepository.save(employee);
        return new EmployeePayrollDTO(employee.getName(), employee.getSalary());
    }


    // PUT Request - Update Employee (Use DTO)
    @PutMapping("/update/{id}")
    public EmployeePayrollDTO updateEmployee(@PathVariable Long id, @RequestBody EmployeePayrollDTO employeeDTO) {
        return employeeRepository.findById(id)
                .map(employee -> {
                    employee.setName(employeeDTO.getName());
                    employee.setSalary(employeeDTO.getSalary());
                    employeeRepository.save(employee);
                    return new EmployeePayrollDTO(employee.getName(), employee.getSalary()); // Returning DTO
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



