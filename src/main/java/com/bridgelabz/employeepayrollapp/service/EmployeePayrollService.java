package com.bridgelabz.employeepayrollapp.service;

import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDTO;
import com.bridgelabz.employeepayrollapp.model.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeePayrollService {

    private final List<Employee> employeeList = new ArrayList<>();
    private long idCounter = 1; // Unique ID generator

    // Add a new employee
    public Employee addEmployee(EmployeePayrollDTO employeeDTO) {
        Employee employee = new Employee(employeeDTO.getName(), employeeDTO.getSalary());
        employee.setId(idCounter++);
        employeeList.add(employee);
        return employee;
    }

    // Retrieve all employees
    public List<Employee> getAllEmployees() {
        return employeeList;
    }

    // Retrieve employee by ID
    public Optional<Employee> getEmployeeById(Long id) {
        return employeeList.stream().filter(emp -> emp.getId().equals(id)).findFirst();
    }

    // Update an employee
    public Employee updateEmployee(Long id, EmployeePayrollDTO employeeDTO) {
        Optional<Employee> existingEmployee = getEmployeeById(id);
        if (existingEmployee.isPresent()) {
            Employee employee = existingEmployee.get();
            employee.setName(employeeDTO.getName());
            employee.setSalary(employeeDTO.getSalary());
            return employee;
        } else {
            throw new RuntimeException("Employee not found with id: " + id);
        }
    }

    // Delete an employee
    public void deleteEmployee(Long id) {
        employeeList.removeIf(employee -> employee.getId().equals(id));
    }
}

