package com.bridgelabz.employeepayrollapp.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor // Generates a constructor with all fields
@NoArgsConstructor
public class EmployeePayrollDTO {
    private String name;
    private double salary;

}
