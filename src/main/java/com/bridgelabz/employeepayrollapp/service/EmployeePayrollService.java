package com.bridgelabz.employeepayrollapp.service;

import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDTO;
import com.bridgelabz.employeepayrollapp.exception.EmployeeNotFoundException;
import com.bridgelabz.employeepayrollapp.model.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class EmployeePayrollService {

    private final List<Employee> employeeList = new ArrayList<>();
    private long idCounter = 1; // Unique ID generator

    // Add a new employee
    public Employee addEmployee(EmployeePayrollDTO employeeDTO) {
        Employee employee = new Employee(employeeDTO.getName(), employeeDTO.getSalary());
        employee.setId(idCounter++);
        employeeList.add(employee);
        log.info("Added new employee: {}", employee);
        return employee;
    }

    // Retrieve all employees
    public List<Employee> getAllEmployees() {
        log.info("Fetching all employees");
        return employeeList;
    }

    // Retrieve employee by ID (throws EmployeeNotFoundException if not found)
    public Employee getEmployeeById(Long id) {
        log.info("Fetching employee with ID: {}", id);
        return employeeList.stream()
                .filter(emp -> emp.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new EmployeeNotFoundException("Employee not found with id: " + id));
    }

    // Update an employee
    public Employee updateEmployee(Long id, EmployeePayrollDTO employeeDTO) {
        Employee employee = getEmployeeById(id); // Throws exception if not found
        employee.setName(employeeDTO.getName());
        employee.setSalary(employeeDTO.getSalary());
        log.info("Updated employee: {}", employee);
        return employee;
    }

    // Delete an employee
    public void deleteEmployee(Long id) {
        Employee employee = getEmployeeById(id); // Throws exception if not found
        employeeList.remove(employee);
        log.warn("Deleted employee with ID: {}", id);
    }
}

