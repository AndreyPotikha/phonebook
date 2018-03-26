package com.example.phonebook.service;

import com.example.phonebook.model.Contacts;
import com.example.phonebook.model.User;

import java.util.List;

public interface ContactsService {

    List<Contacts> getAll();

    List<Contacts> findByUser(User user);

    void save(Contacts contacts);

    void del(Long id);

    List<Contacts> findAllByNameContainsAndUser(String name, User user);

    List<Contacts> findAllBySurnameContainsAndUser(String surname, User user);

    List<Contacts> findAllByPhoneNumberContainsAndUser(String phone, User user);
}
