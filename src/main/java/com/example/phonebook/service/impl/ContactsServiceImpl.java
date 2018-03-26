package com.example.phonebook.service.impl;

import com.example.phonebook.model.Contacts;
import com.example.phonebook.model.User;
import com.example.phonebook.repository.ContactsRepository;
import com.example.phonebook.service.ContactsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactsServiceImpl implements ContactsService {

    @Autowired
    private ContactsRepository contactsRepository;

    @Override
    public List<Contacts> getAll() {
        return (List<Contacts>) contactsRepository.findAll();
    }

    @Override
    public List<Contacts> findByUser(User user) {
        return contactsRepository.findAllByUser(user);
    }

    @Override
    public void save(Contacts contacts) {
        contactsRepository.save(contacts);
    }

    @Override
    public void del(Long id) {
        contactsRepository.delete(id);
    }

    @Override
    public List<Contacts> findAllByNameContainsAndUser(String name, User user) {
        return contactsRepository.findAllByNameContainsAndUser(name, user);
    }

    @Override
    public List<Contacts> findAllBySurnameContainsAndUser(String surname, User user) {
        return contactsRepository.findAllBySurnameContainsAndUser(surname, user);
    }

    @Override
    public List<Contacts> findAllByPhoneNumberContainsAndUser(String phone, User user) {
        return contactsRepository.findAllByPhoneNumberContainsAndUser(phone, user);
    }


}
