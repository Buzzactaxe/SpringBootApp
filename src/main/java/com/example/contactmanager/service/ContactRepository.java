package com.example.contactmanager.service;



import com.example.contactmanager.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Integer> {

    //getAllContacts()
    //getContact(String id)
    //updateContact(Contact c)
    //deleteContact(String id)



}
