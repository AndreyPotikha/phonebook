package com.example.phonebook.service;

import com.example.phonebook.model.User;

public interface UserService {

    public void saveNewUser(User user);

    public boolean logIn(User user);

    public User findByEmail(String email);

}
