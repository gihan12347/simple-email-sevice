package com.example.services;

import com.example.DTOs.MyDetailsDTO;
import com.example.configs.AppParamsConfig;
import org.springframework.stereotype.Service;

@Service
public class MyDetailsService {

    private final AppParamsConfig appConfig;

    public MyDetailsService(AppParamsConfig appConfig) {
        this.appConfig = appConfig;
    }

    public MyDetailsDTO getMyDetailsDTO() {
        return new MyDetailsDTO(appConfig.getToEmail(), appConfig.getContactNo(), appConfig.getLocation());
    }
}
