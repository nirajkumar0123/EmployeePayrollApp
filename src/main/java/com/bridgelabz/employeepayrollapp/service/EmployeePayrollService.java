package com.bridgelabz.employeepayrollapp.service;

import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDTO;
import com.bridgelabz.employeepayrollapp.exception.EmployeeNotFoundException;
import com.bridgelabz.employeepayrollapp.model.Employee;
import com.bridgelabz.employeepayrollapp.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
@Service
public class EmployeePayrollService {

    @Autowired
    private EmployeeRepository employeeRepository;

    // Retrieve all employees from DB
    public List<Employee> getAllEmployees() {
        log.info("Fetching all employees from DB");
        return employeeRepository.findAll();
    }

    // Retrieve employee by ID
    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException("Employee not found with id: " + id));
    }

    // Update an employee
    public Employee updateEmployee(Long id, EmployeePayrollDTO employeeDTO) {
        Employee employee = getEmployeeById(id);
        employee.setName(employeeDTO.getName());
        employee.setSalary(employeeDTO.getSalary());
        employee.setGender(employeeDTO.getGender());
        employee.setDepartments(employeeDTO.getDepartments());
        employee.setProfilePic(employeeDTO.getProfilePic());
        employee.setNote(employeeDTO.getNote());
        employee.setStartDate(employeeDTO.getStartDate());

        Employee updatedEmployee = employeeRepository.save(employee);
        log.info("Updated employee: {}", updatedEmployee);
        return updatedEmployee;
    }

    // Delete an employee
    public void deleteEmployee(Long id) {
        Employee employee = getEmployeeById(id);
        employeeRepository.delete(employee);
        log.warn("Deleted employee with ID: {}", id);
      
    // Save Employee to Database
    public Employee addEmployee(EmployeePayrollDTO employeeDTO) {
        Employee employee = new Employee(employeeDTO);
        Employee savedEmployee = employeeRepository.save(employee);
        log.info("Added new employee: {}", savedEmployee);
        return savedEmployee;
    }
}
