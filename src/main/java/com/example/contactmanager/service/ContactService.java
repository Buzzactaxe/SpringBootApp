package com.example.contactmanager.service;


import com.example.contactmanager.model.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactService {
    @Autowired
    private DataDao datadao;

    public List<Contact> getContactList() {

        return datadao.getAllContacts();
    }

    public void addContact(Contact c) {
        datadao.addContact(c);
    }

    public void deleteFromId(int id) {
        datadao.deleteContact(id);
    }
}
