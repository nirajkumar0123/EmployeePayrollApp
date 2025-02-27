package com.bridgelabz.employeepayrollapp.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class EnvironmentController {

    @Value("${spring.profiles.active}")
    private String activeProfile;

    @GetMapping("/check-env")
    public String checkEnvironment() {
        return "Current Active Profile: " + activeProfile;
    }
}
