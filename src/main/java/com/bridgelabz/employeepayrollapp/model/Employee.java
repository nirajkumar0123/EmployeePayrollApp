package com.bridgelabz.employeepayrollapp.model;

import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private double salary;
    private String gender;
    private LocalDate startDate;
    private String note;
    private String profilePic;
    private List<String> departments;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public Employee(Long employeeId, EmployeePayrollDTO empPayrollDTO) {
        this.id = employeeId;
        this.name = empPayrollDTO.name;
        this.salary = empPayrollDTO.salary;
        this.gender = empPayrollDTO.gender;
        this.startDate = empPayrollDTO.startDate;
        this.note = empPayrollDTO.note;
        this.profilePic = empPayrollDTO.profilePic;
        this.departments = empPayrollDTO.department;
    }

    public Employee(long l, @NotEmpty(message = "Name cannot be empty") @Pattern(regexp = "^[A-Z][a-zA-Z\\s]{2,}$", message = "Name must start with a capital letter and have at least 3 characters") String name, @Min(value = 500, message = "Min Wage should be more than 500") double salary, @Pattern(regexp = "^(male|female|other)$", message = "Gender should be male, female, or other") String gender, @PastOrPresent(message = "Start date should be in the past or present") LocalDate startDate, @NotBlank(message = "Note cannot be empty") String note, @NotBlank(message = "Profile picture URL cannot be empty") String profilePic, @NotEmpty(message = "Department cannot be empty") List<String> department) {
    }

    public void setDepartment(@NotEmpty(message = "Department cannot be empty") List<String> department) {
    }
}



