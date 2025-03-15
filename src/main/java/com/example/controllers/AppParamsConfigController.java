package com.example.controllers;

import com.example.services.AppPramsConfigService;
import com.example.utils.ValidationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class AppParamsConfigController {
    @Autowired
    private AppPramsConfigService appPramsConfigService;

    @PostMapping("/updateMyDetails")
    public String updateValue(@RequestParam String updatedField, @RequestParam String updatedValue, RedirectAttributes redirectAttributes) {
        System.out.println("updatedField: " + updatedField + " updatedValue: " + updatedValue);
        if (!ValidationUtil.isEmpty(updatedValue)){
            appPramsConfigService.updateAppParamValue(updatedField, updatedValue, redirectAttributes);
        } else {
            AppPramsConfigService.setFlashAttributes("You can't update empty value for " + updatedField + "!", false, redirectAttributes);
        }
        return "redirect:/dashboard";
    }
}
