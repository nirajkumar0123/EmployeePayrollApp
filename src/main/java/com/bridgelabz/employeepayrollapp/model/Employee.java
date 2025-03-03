package com.bridgelabz.employeepayrollapp.model;

import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDTO;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;
import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Table(name = "employee_payroll") // Custom table name
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Name cannot be empty")
    @Pattern(regexp = "^[A-Z][a-zA-Z\\s]{2,}$", message = "Name must start with a capital letter and have at least 3 characters")
    private String name;

    @Min(value = 500, message = "Salary must be at least 500")
    private double salary;

    @Pattern(regexp = "^(male|female|other)$", message = "Gender should be male, female, or other")
    private String gender;

    @PastOrPresent(message = "Start date should be in the past or present")
    private LocalDate startDate;

    @NotBlank(message = "Note cannot be empty")
    private String note;

    @NotBlank(message = "Profile picture URL cannot be empty")
    private String profilePic;

    @ElementCollection
    @CollectionTable(name = "employee_department", joinColumns = @JoinColumn(name = "id"))
    @Column(name = "department")
    @NotEmpty(message = "At least one department is required")
    private List<String> departments;

    // Default constructor
    public Employee() {}

    // Constructor from DTO
    public Employee(EmployeePayrollDTO empPayrollDTO) {
        this.name = empPayrollDTO.getName();
        this.salary = empPayrollDTO.getSalary();
        this.gender = empPayrollDTO.getGender();
        this.startDate = empPayrollDTO.getStartDate();
        this.note = empPayrollDTO.getNote();
        this.profilePic = empPayrollDTO.getProfilePic();
        this.departments = empPayrollDTO.getDepartments();
    }
}
