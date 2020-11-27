package com.example.contactmanager.controllers;

import com.example.contactmanager.model.Contact;
import com.example.contactmanager.service.ContactDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ContactController {

   @Autowired
   private ContactDao contactDao;

   //Get
    @RequestMapping("/contacts")
    public List<Contact> getAllContacts(){
        return contactDao.getAllContacts();
    }

    //Get
    @RequestMapping("contacts/{id}")
    public Contact getId(@PathVariable int id){
        return contactDao.getContact(id);
    }

    //Post
    @RequestMapping(method = RequestMethod.POST, value="/contacts")
    public void addContact(@RequestBody Contact c) {
        contactDao.addContact(c);
    }

    //PUT
    @RequestMapping(method = RequestMethod.PUT, value="/contacts/{id}")
    public void updateContact(@RequestBody Contact c, @PathVariable int id) {
      contactDao.updateContact(id, c);

    }

    //DELETE
    @RequestMapping(method = RequestMethod.DELETE, value="/contacts/{id}")
    public void deleteContact(@PathVariable int id) {
      contactDao.deleteContact(id);
    }

}
