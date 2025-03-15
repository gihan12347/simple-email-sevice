package com.example.services;

import com.example.configs.AppParamsConfig;
import com.example.utils.ValidationUtil;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Service
public class AppPramsConfigService {
    private final AppParamsConfig appConfig;

    public AppPramsConfigService(AppParamsConfig appConfig) {
        this.appConfig = appConfig;
    }

    public void updateAppParamValue(String updatedField, String updatedValue, RedirectAttributes redirectAttributes) {
        switch (updatedField) {
            case "email":
                updateEmail(updatedValue, redirectAttributes);
                break;
            case "contact":
                updateContactNumber(updatedValue, redirectAttributes);
                break;
            case "address":
                updateAddress(updatedValue, redirectAttributes);
                break;
            default:
                break;
        }
    }

    private void updateEmail(String updatedValue, RedirectAttributes redirectAttributes) {
        if (ValidationUtil.isValidEmail(updatedValue)) {
            appConfig.setToEmail(updatedValue);
            setFlashAttributes("Your Email updated successfully!", true, redirectAttributes);
        } else {
            setFlashAttributes("Invalid Email address....please check your email before submitting.!", false, redirectAttributes);
        }
    }

    private void updateContactNumber(String updatedValue, RedirectAttributes redirectAttributes) {
        if (ValidationUtil.isValidPhoneNumber(updatedValue)) {
            appConfig.setContactNo(updatedValue);
            setFlashAttributes("Your Contact No updated successfully!", true, redirectAttributes);
        } else {
            setFlashAttributes("Invalid phone number....please check your phone number before submitting.!", false, redirectAttributes);
        }
    }

    private void updateAddress(String updatedValue, RedirectAttributes redirectAttributes) {
        appConfig.setLocation(updatedValue);
        setFlashAttributes("Your address updated successfully!", true, redirectAttributes);
    }

    public static void setFlashAttributes(String message, boolean isUpdated, RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("isUpdated", isUpdated);
        redirectAttributes.addFlashAttribute("message", message);
    }
}
