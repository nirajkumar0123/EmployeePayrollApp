package com.bridgelabz.employeepayrollapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
}



