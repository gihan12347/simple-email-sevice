package com.example.controllers;

import com.example.configs.AppParamsConfig;
import com.example.services.MyDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.security.core.Authentication;

import javax.servlet.http.HttpServletResponse;

@Controller
public class LoginController {

    @Autowired
    private MyDetailsService myDetailsService;

    @GetMapping("/login")
    public String login() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null && auth.isAuthenticated() && !auth.getPrincipal().equals("anonymousUser")) {
            return "redirect:/dashboard";  // Redirect logged-in users to dashboard
        }
        return "login";  // Load login.html
    }

    @GetMapping("/dashboard")
    public String adminPage(Model model) {
        model.addAttribute("userDetails", myDetailsService.getMyDetailsDTO());
        return "dashboard";
    }
}

