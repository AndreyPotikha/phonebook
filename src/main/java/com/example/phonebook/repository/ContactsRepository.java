package com.example.phonebook.repository;

import com.example.phonebook.model.Contacts;
import com.example.phonebook.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContactsRepository extends CrudRepository<Contacts, Long> {

    List<Contacts> findAll();

    List<Contacts> findAllByUser(User user);

    List<Contacts> findAllByNameContainsAndUser(String name, User user);

    List<Contacts> findAllBySurnameContainsAndUser(String surname, User user);

    List<Contacts> findAllByPhoneNumberContainsAndUser(String phone, User user);
}
