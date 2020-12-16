package com.example.contactmanager.controllers;

import com.example.contactmanager.model.api.ContactResource;
import com.example.contactmanager.model.api.NumbersResource;
import com.example.contactmanager.model.persistence.Contact;
import com.example.contactmanager.model.persistence.Numbers;
import com.example.contactmanager.service.ContactService;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@EnableSwagger2
//Swagger Mapper
@RestController
public class ContactController {
    @Autowired
    private ContactService contactService;

    //Get
    @RequestMapping("/contacts")
    @ApiOperation(value = "Shows all Contacts in Database", response = Contact.class)
    public List<ContactResource> getAllContacts() {

    return    contactService.getAllContacts()
                .stream() //initiate
                .map(entity -> new ContactResource(entity.getId(),
                        entity.getName(),
                        entity.getSurname(),
                        entity.getAge(),
                        toNumberResource(entity.getNumbers()))) //processing
                .collect(Collectors.toList()); //termination

//        List<ContactResource> contactResources = new ArrayList<>();
//        for (Contact contact : contactService.getAllContacts()) {
//
//            contactResources.add(new ContactResource(contact.getId(),
//                    contact.getName(),
//                    contact.getSurname(),
//                    contact.getAge(),
//                    toNumberResource(contact.getNumbers())));
//        }
//        return new ResponseEntity<>(contactResources, HttpStatus.OK);
    }

    private NumbersResource toNumberResource(Numbers numbers) {
        return new NumbersResource(numbers.getN_id(), numbers.getHomeNumber(), numbers.getMobileNumber());
    }

    //Get
    @GetMapping("contacts/{id}")
    @ApiOperation(value = "Finds Contact by ID", notes = "Provide an id (type = int) to find a specific contact in the Database", response = Contact.class)
    public Contact getId(@PathVariable int id) {
        return contactService.getContact(id);
    }

    //Post
    @PostMapping("/contacts")
//    @RequestMapping(value =  "/contacts")
    @ApiOperation(value = "Adds a new Contact to Database", notes = "Provide contact contact model information to add new object", response = Contact.class)
    public void addContact(@RequestBody Contact c) {
        contactService.addContact(c);
    }

    //PUT
    @PutMapping("/contacts/{id}")
    @ApiOperation(value = "Updades a Contact from Database", notes = "Provide an id (type = int) to find a specific contact to Update", response = Contact.class)
    public void updateContact(@RequestBody Contact c, @PathVariable int id) {
        contactService.updateContact(id, c);
    }

    //DELETE
    @DeleteMapping("/contacts/{id}")
    @ApiOperation(value = "Deletes Contact by ID", notes = "Provide an id (type = int) to Delete a specific contact in the Database", response = Contact.class)
    public void deleteContact(@PathVariable int id) {
        contactService.deleteContact(id);
    }

    //PATCH
    @PatchMapping("/contacts/{id}")
    @ApiOperation(value = "Updates a specific field of the Contact object", notes = "Provide a specific field to update", response = Contact.class)
    public void patchContact(@PathVariable int id, @RequestBody Map<Object, Object> fields) {
        Contact contact = contactService.getContact(id);
        //Map key is field name v is value
        fields.forEach((k, v) -> {
            Field field = ReflectionUtils.findField(Contact.class, (String) k);
            field.setAccessible(true);
            ReflectionUtils.setField(field, contact, v);
        });
        contactService.updateContact(id, contact);
    }

}
