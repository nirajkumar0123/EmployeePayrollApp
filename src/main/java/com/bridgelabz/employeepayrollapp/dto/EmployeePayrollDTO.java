package com.bridgelabz.employeepayrollapp.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@ToString
@Data
public class EmployeePayrollDTO {

    @NotEmpty(message = "Name cannot be empty")
    @Pattern(regexp = "^[A-Z][a-zA-Z\\s]{2,}$", message = "Name must start with a capital letter and have at least 3 characters")
    public String name;

    @Min(value = 500, message = "Min Wage should be more than 500")
    public double salary;

    @Pattern(regexp = "^(male|female|other)$", message = "Gender should be male, female, or other")
    public String gender;

    @JsonFormat(pattern = "dd MMM yyyy")
    @PastOrPresent(message = "Start date should be in the past or present")
    public LocalDate startDate;

    @NotBlank(message = "Note cannot be empty")
    public String note;

    @NotBlank(message = "Profile picture URL cannot be empty")
    public String profilePic;

    @NotEmpty(message = "Department cannot be empty")
    public List<String> department;
}
