package com.bridgelabz.employeepayrollapp.dto;

import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Data // Lombok annotation to generate getters, setters, toString, etc.
@NoArgsConstructor
@AllArgsConstructor
public class EmployeePayrollDTO {

    @NotBlank(message = "Name cannot be empty")  // Ensures name is not blank
    private String name;

    @Min(value = 3000, message = "Salary must be at least 3000") // Min salary validation
    private double salary;

    @Pattern(regexp = "male|female|other", message = "Gender must be male, female, or other") // Restrict gender values
    private String gender;

    @NotEmpty(message = "At least one department is required")
    private List<String> departments;

    @NotBlank(message = "Profile picture URL cannot be empty")
    private String profilePic;

    private String note;

    @PastOrPresent(message = "Start date cannot be in the future")
    private LocalDate startDate;
}

