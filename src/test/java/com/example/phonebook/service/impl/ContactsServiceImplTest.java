package com.example.phonebook.service.impl;

import com.example.phonebook.model.Contacts;
import com.example.phonebook.model.User;
import com.example.phonebook.repository.ContactsRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
public class ContactsServiceImplTest {

    @Mock
    private ContactsRepository contactsRepository;
    @Mock
    private Contacts contacts;
    @InjectMocks
    private ContactsServiceImpl contactsService;

    @Test
    public void getAll() {
        when(contactsRepository.findAll()).thenReturn(new ArrayList<>());
        List<Contacts> all = contactsService.getAll();
        verify(contactsRepository).findAll();
    }

    @Test
    public void findByUser() {
        when(contactsRepository.findAllByUser(new User())).thenReturn(new ArrayList<>());
    }

    @Test
    public void save() {
        when(contactsRepository.save(new Contacts())).thenReturn(null);
    }

    @Test
    public void findAllByNameContainsAndUser() {
        when(contactsRepository.findAllByPhoneNumberContainsAndUser("", new User())).thenReturn(new ArrayList<>());
    }

    @Test
    public void findAllBySurnameContainsAndUser() {
        when(contactsRepository.findAllBySurnameContainsAndUser("", new User())).thenReturn(new ArrayList<>());
    }

    @Test
    public void findAllByPhoneNumberContainsAndUser() {
        when(contactsRepository.findAllByPhoneNumberContainsAndUser("", new User())).thenReturn(new ArrayList<>());
    }
}