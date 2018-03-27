package com.example.phonebook.service.impl;

import com.example.phonebook.model.User;
import com.example.phonebook.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceImplTest {

    @Mock
    private UserRepository userRepository;
    @Mock
    private User user;
    @InjectMocks
    private UserServiceImpl userService;


    @Test
    public void saveNewUser() {
        when(userRepository.save(user)).thenReturn(user);
        User u = userService.saveNewUser(user);
        verify(userRepository).save(u);
    }


    @Test
    public void findByEmail() {
        when(userRepository.findByEmail("a.potiha@gmail.com")).thenReturn(user);
        User byEmail = userService.findByEmail("a.potiha@gmail.com");
        verify(userRepository).findByEmail("a.potiha@gmail.com");
    }
}