package com.example.DTOs;

public class MyDetailsDTO {
    private String toEmail;
    private String contactNo;
    private String location;

    public MyDetailsDTO(String toEmail, String contactNo, String location) {
        this.toEmail = toEmail;
        this.contactNo = contactNo;
        this.location = location;
    }

    public String getToEmail() {
        return toEmail;
    }

    public void setToEmail(String toEmail) {
        this.toEmail = toEmail;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
