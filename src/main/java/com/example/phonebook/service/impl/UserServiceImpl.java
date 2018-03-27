package com.example.phonebook.service.impl;

import com.example.phonebook.model.User;
import com.example.phonebook.repository.UserRepository;
import com.example.phonebook.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User saveNewUser(User user) {
        userRepository.save(user);
        return user;
    }

    @Override
    public boolean logIn(User user) {
        Iterable<User> all = userRepository.findAll();
        for (User elem : all) {
            if (elem.getEmail().equals(user.getEmail()) && elem.getPassword().equals(user.getPassword())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}
