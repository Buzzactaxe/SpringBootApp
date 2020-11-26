package com.example.contactmanager.service;


import com.example.contactmanager.model.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataDao {
    @Autowired
    private ContactRepository contactRepository;

    public List<Contact> getAllContacts() {
        List<Contact> contacts = new ArrayList<>();
        contacts.addAll(contactRepository.findAll());
        return contacts;
    }

    public void addContact(Contact c){
        contactRepository.save(c);
    }

    public Contact getContact(int id){
        return contactRepository.getOne(id);
    }

    public void updateContact(int id, Contact c){
        contactRepository.save(c);
    }

    public void deleteContact(int id){
        contactRepository.deleteById(id);
    }



}
