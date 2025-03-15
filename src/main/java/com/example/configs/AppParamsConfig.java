package com.example.configs;

import org.springframework.stereotype.Component;

@Component
public class AppParamsConfig {

    private String toEmail = "gdkadawathage@gmail.com";
    private String contactNo = "76 2916 669";
    private String location = "Naotuntta, Matara, Sri Lanka ";

    public String getToEmail() {
        return toEmail;
    }

    public void setToEmail(String toEmail) {
        this.toEmail = toEmail;
    }

    public String getContactNo() {
        return this.contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public String getLocation() {
        return this.location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}

