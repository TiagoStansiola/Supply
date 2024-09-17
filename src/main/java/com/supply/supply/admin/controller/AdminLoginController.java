package com.supply.supply.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class AdminLoginController {

    @GetMapping("/index-admin")
    public String index() {
        return "index-admin";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/home")
    public String home(Model model) {
        return "home";
    }

    @GetMapping("/register")
    public String register() {
        return "register";
    }
}

