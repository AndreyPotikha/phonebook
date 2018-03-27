package com.example.phonebook.controller;

import com.example.phonebook.model.User;
import com.example.phonebook.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;


@Controller
@RequestMapping("users")
@SessionAttributes(types = User.class)
public class UserController {

    @Autowired
    private UserService userService;

    @ModelAttribute("user")
    public User setUpUserForm() {
        return new User();
    }

    @RequestMapping(value = "/new_user", method = RequestMethod.POST)
    public String newUser(User user, @RequestParam String email, @RequestParam String password) {
        user.setEmail(email);
        user.setPassword(password);
        userService.saveNewUser(user);
        return "main";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String logIn(User user, @RequestParam String email, @RequestParam String password) {
        user.setEmail(email);
        user.setPassword(password);
        boolean log = userService.logIn(user);
        if (log) {
            return "main";
        }
        return "index";
    }

    @RequestMapping(value = "/log_out", method = RequestMethod.GET)
    public String logOut(SessionStatus sessionStatus) {
        sessionStatus.setComplete();
        return "index";
    }
}
