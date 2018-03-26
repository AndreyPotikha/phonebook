package com.example.phonebook.controller;

import com.example.phonebook.model.Contacts;
import com.example.phonebook.model.User;
import com.example.phonebook.service.ContactsService;
import com.example.phonebook.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("contacts")
public class ContactsController {

    @Autowired
    private ContactsService contactsService;

    @Autowired
    private UserService userService;

    private User sessionUser = new User();

    @RequestMapping("new_contacts")
    public String newContacts() {
        return "new_contacts";
    }

    @RequestMapping("all_contacts")
    public String setUpContactsForm(@RequestParam String email, Model model) {
        User byEmail = userService.findByEmail(email);
        sessionUser.setEmail(email);
        if (byEmail == null) {
            return "index";
        }
        model.addAttribute("get_all_contacts", contactsService.findByUser(byEmail));
        return "all_contacts";
    }

    @RequestMapping(value = "/add_contacts", method = RequestMethod.POST)
    public String newContacts(@RequestParam String userEmail, @RequestParam String name, @RequestParam String surname
            , @RequestParam String patronymic, @RequestParam String phoneNumber
            , @RequestParam String email) {
        Contacts contacts = new Contacts();
        contacts.setName(name);
        contacts.setSurname(surname);
        contacts.setPatronymic(patronymic);
        contacts.setPhoneNumber(phoneNumber);
        contacts.setEmail(email);

        User user = userService.findByEmail(userEmail);
        contacts.setUser(user);

        contactsService.save(contacts);
        return "main";
    }

    @RequestMapping("/del_contacts")
    public String deleteContacts(@RequestParam String id, Model model) {
        contactsService.del(Long.valueOf(id));
        User byEmail = userService.findByEmail(sessionUser.getEmail());

        model.addAttribute("get_all_contacts", contactsService.findByUser(byEmail));

        return "all_contacts";
    }

    @RequestMapping("/update_contacts")
    public String updateContacts(@RequestParam String id, @RequestParam String name
            , @RequestParam String surname, @RequestParam String patronymic
            , @RequestParam String phoneNumber, @RequestParam String email
            , @RequestParam String userEmail, Model model) {

        Contacts contacts = new Contacts();
        contacts.setId(Long.parseLong(id));
        contacts.setName(name);
        contacts.setSurname(surname);
        contacts.setPatronymic(patronymic);
        contacts.setPhoneNumber(phoneNumber);
        contacts.setEmail(email);

        User byEmail = userService.findByEmail(userEmail);
        contacts.setUser(byEmail);

        contactsService.save(contacts);

        model.addAttribute("get_all_contacts", contactsService.findByUser(byEmail));

        return "all_contacts";
    }

    @RequestMapping("/filter_contacts")
    public String filterContacts(@RequestParam String filterName, @RequestParam String userEmail, Model model) {

        User byEmail = userService.findByEmail(userEmail);

        Set<Contacts> allFilterContacts = new HashSet<>();

        List<Contacts> allByUserAndNameContains = contactsService.findAllByNameContainsAndUser(filterName, byEmail);
        List<Contacts> allByUserAndSurnameContains = contactsService.findAllBySurnameContainsAndUser(filterName, byEmail);
        List<Contacts> allByUserAndPhoneNumberContains = contactsService.findAllByPhoneNumberContainsAndUser(filterName, byEmail);

        allFilterContacts.addAll(allByUserAndNameContains);
        allFilterContacts.addAll(allByUserAndSurnameContains);
        allFilterContacts.addAll(allByUserAndPhoneNumberContains);

        model.addAttribute("get_all_contacts", allFilterContacts);

        return "all_contacts";
    }

}
