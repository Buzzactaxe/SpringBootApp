package com.example.contactmanager.service;


import com.example.contactmanager.model.persistence.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConsoleService {
    @Autowired
    private ContactService contactService;

    public List<Contact> getContactList() {

        return contactService.getAllContacts();
    }

    public void addContact(Contact c) {
        contactService.addContact(c);
    }

    public void deleteFromId(int id) {
        contactService.deleteContact(id);
    }
}
