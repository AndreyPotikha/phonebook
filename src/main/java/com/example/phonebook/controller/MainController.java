package com.example.phonebook.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("")
public class MainController {

    @RequestMapping("/main")
    public String mainPage() {
        return "main";
    }

    @RequestMapping("")
    public String loginPage(Model model) {
        return "index";
    }

    @RequestMapping("/new_registration")
    public String newRegistration() {
        return "registration";
    }

}
