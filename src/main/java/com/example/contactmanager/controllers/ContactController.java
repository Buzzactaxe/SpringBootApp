package com.example.contactmanager.controllers;

import com.example.contactmanager.model.api.ContactResource;
import com.example.contactmanager.model.api.NumbersResource;
import com.example.contactmanager.model.persistence.Contact;
import com.example.contactmanager.model.persistence.Numbers;
import com.example.contactmanager.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class ContactController {

   @Autowired
   private ContactService contactService;

   //Get
    @RequestMapping("/contacts")
    public List<ContactResource> getAllContacts() {
        return

                contactService.getAllContacts()
                        .stream() //initiate
                        .map(entity -> new ContactResource(entity.getId(),
                                entity.getName(),
                                entity.getSurname(),
                                entity.getAge(),
                                toNumberResource(entity.getNumbers()))) //processing
                        .collect(Collectors.toList()); //termination


//            List<ContactResource> contactResources = new ArrayList<>();
//            for(Contact contact: contactDao.getAllContacts()){
//
//                contactResources.add(new ContactResource(contact.getId(),
//                        contact.getName(),
//                        contact.getSurname(),
//                        contact.getAge(),
//                        toNumberResource(contact.getNumbers())))
//            }
//            return contactResources;
    }

    private NumbersResource toNumberResource(Numbers numbers){
        return new NumbersResource(numbers.getN_id(),numbers.getHomeNumber(),numbers.getMobileNumber());
    }

    //Get
    @RequestMapping("contacts/{id}")
    public Contact getId(@PathVariable int id){
        return contactService.getContact(id);
    }

    //Post
    @RequestMapping(method = RequestMethod.POST, value="/contacts")
    public void addContact(@RequestBody Contact c) {
        contactService.addContact(c);
    }

    //PUT
    @RequestMapping(method = RequestMethod.PUT, value="/contacts/{id}")
    public void updateContact(@RequestBody Contact c, @PathVariable int id) {
      contactService.updateContact(id, c);
    }

    //DELETE
    @RequestMapping(method = RequestMethod.DELETE, value="/contacts/{id}")
    public void deleteContact(@PathVariable int id) {
      contactService.deleteContact(id);
    }

}
