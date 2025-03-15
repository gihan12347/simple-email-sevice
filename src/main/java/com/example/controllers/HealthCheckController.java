package com.example.controllers;

import com.example.DTOs.ResponceDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/email")
public class HealthCheckController {

    @GetMapping
    public ResponceDto healthCheck() {
        ResponceDto responceDto = new ResponceDto();
        responceDto.setStatus(true);
        responceDto.setMessage("Welcome to the email service!");
        return responceDto;
    }
}
