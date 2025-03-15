package com.example.controllers;

import com.example.DTOs.ResponceDto;
import com.example.services.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/email")
public class EmailSendingController {

    @Autowired
    private EmailService emailService;

    @CrossOrigin(origins = "*")
    @PostMapping("/sendEmail")
    public ResponceDto sendEmail(@RequestParam String name, @RequestParam String telephone, @RequestParam String subject, @RequestParam String text) {
        boolean response = emailService.sendSimpleEmail(subject, text, name, telephone);
        ResponceDto responceDto = new ResponceDto();
        if (response) {
            responceDto.setStatus(true);
            responceDto.setMessage("Email sent successfully!");
        } else {
            responceDto.setStatus(false);
            responceDto.setMessage("Email not sent successfully!");
        }
        return responceDto;
    }
}
