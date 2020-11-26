package com.example.contactmanager;

import com.example.contactmanager.model.Contact;
import com.example.contactmanager.service.DataDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HelloController {

   @Autowired
   private DataDao dataDao;

   //Get
    @RequestMapping("/contacts")
    public List<Contact> getAllContacts(){
        return dataDao.getAllContacts();
    }

    //Get
    @RequestMapping("contacts/{id}")
    public Contact getId(@PathVariable int id){
        return dataDao.getContact(id);
    }

    //Post
    @RequestMapping(method = RequestMethod.POST, value="/contacts")
    public void addContact(@RequestBody Contact c) {
        dataDao.addContact(c);
    }

    //PUT
    @RequestMapping(method = RequestMethod.PUT, value="/contacts/{id}")
    public void updateContact(@RequestBody Contact c, @PathVariable int id) {
      dataDao.updateContact(id, c);

    }

    //DELETE
    @RequestMapping(method = RequestMethod.DELETE, value="/contacts/{id}")
    public void deleteContact(@PathVariable int id) {
      dataDao.deleteContact(id);
    }

}
