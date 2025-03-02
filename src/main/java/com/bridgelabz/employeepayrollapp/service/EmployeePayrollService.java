package com.bridgelabz.employeepayrollapp.service;

import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDTO;
import com.bridgelabz.employeepayrollapp.exception.EmployeeNotFoundException;
import com.bridgelabz.employeepayrollapp.model.Employee;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class EmployeePayrollService {

    private final List<Employee> employeeList = new ArrayList<>();
    private long idCounter = 1; // Unique ID generator

    // Add a new employee with additional properties
    public Employee addEmployee(EmployeePayrollDTO employeeDTO) {
        Employee employee = new Employee(
                idCounter++,
                employeeDTO.getName(),
                employeeDTO.getSalary(),
                employeeDTO.getGender(),
                employeeDTO.getStartDate(),
                employeeDTO.getNote(),
                employeeDTO.getProfilePic(),
                employeeDTO.getDepartment()
        );
        employeeList.add(employee);
        log.info("Added new employee: {}", employee);
        return employee;
    }

    // Retrieve all employees
    public List<Employee> getAllEmployees() {
        log.info("Fetching all employees");
        return employeeList;
    }

    // Retrieve employee by ID
    public Employee getEmployeeById(Long id) {
        log.info("Fetching employee with ID: {}", id);
        return employeeList.stream()
                .filter(emp -> emp.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new EmployeeNotFoundException("Employee not found with id: " + id));
    }

    // Update an employee with additional fields
    public Employee updateEmployee(Long id, EmployeePayrollDTO employeeDTO) {
        Employee employee = getEmployeeById(id); // Throws exception if not found
        employee.setName(employeeDTO.getName());
        employee.setSalary(employeeDTO.getSalary());
        employee.setGender(employeeDTO.getGender());
        employee.setStartDate(employeeDTO.getStartDate());
        employee.setNote(employeeDTO.getNote());
        employee.setProfilePic(employeeDTO.getProfilePic());
        employee.setDepartment(employeeDTO.getDepartment());
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
