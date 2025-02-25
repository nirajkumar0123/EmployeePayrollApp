package com.bridgelabz.employeepayrollapp.service;

import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDTO;
import com.bridgelabz.employeepayrollapp.model.Employee;
import com.bridgelabz.employeepayrollapp.repository.EmployeeRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeePayrollService {

    private final EmployeeRepository employeeRepository;

    public EmployeePayrollService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Employee addEmployee(EmployeePayrollDTO employeeDTO) {
        Employee employee = new Employee(employeeDTO.getName(), employeeDTO.getSalary());
        return employeeRepository.save(employee);
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Optional<Employee> getEmployeeById(Long id) {
        return employeeRepository.findById(id);
    }

    public Employee updateEmployee(Long id, EmployeePayrollDTO employeeDTO) {
        return employeeRepository.findById(id).map(emp -> {
            emp.setName(employeeDTO.getName());
            emp.setSalary(employeeDTO.getSalary());
            return employeeRepository.save(emp);
        }).orElseThrow(() -> new RuntimeException("Employee not found!"));
    }

    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }
}

