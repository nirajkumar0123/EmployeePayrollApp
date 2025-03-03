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

    // Save Employee to Database
    public Employee addEmployee(EmployeePayrollDTO employeeDTO) {
        Employee employee = new Employee(employeeDTO);
        Employee savedEmployee = employeeRepository.save(employee);
        log.info("Added new employee: {}", savedEmployee);
        return savedEmployee;
    }
}
