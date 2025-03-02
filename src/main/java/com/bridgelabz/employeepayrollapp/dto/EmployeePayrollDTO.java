package com.bridgelabz.employeepayrollapp.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.*;

import java.util.List;

@ToString
@Data
public class EmployeePayrollDTO {

    @NotEmpty(message = "Name cannot be empty")
    @Pattern(regexp = "^[A-Z][a-zA-Z\\s]{2,}$", message = "Name must start with a capital letter and have at least 3 characters")
    private String name;

    @Min(value = 500, message = "Min Wage should be more than 500")
    private double salary;

    public String gender;
    public String startDate;
    public String note;
    public String profilePic;
    public List<String> department;
}
