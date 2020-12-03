package com.example.contactmanager.controllers;



import com.example.contactmanager.model.persistence.Numbers;
import com.example.contactmanager.service.NumbersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class NumbersController {

   @Autowired
  private NumbersService numbersService;

   //Get
    @RequestMapping("/contacts/{contactId}/numbers")
    public List<Numbers> getAllNumbers(@PathVariable int id){
        return numbersService.getAllNumbers(id);
    }

    //Get
    @RequestMapping("contacts/{contactId}/numbers/{id}")
    public Numbers getId(@PathVariable int id){
        return numbersService.getNumber(id);
    }

    //Post
    @RequestMapping(method = RequestMethod.POST, value="/contacts/{contactId}/numbers/{id}")
    public void addNumber(@RequestBody Numbers n) {
        numbersService.addNumber(n);
    }

    //PUT
    @RequestMapping(method = RequestMethod.PUT, value="/contacts/{contactId}/numbers/{id}")
    public void updateNumber(@RequestBody Numbers n, @PathVariable int id) {
      numbersService.updateNumber(id, n);

    }

    //DELETE
    @RequestMapping(method = RequestMethod.DELETE, value="/contacts/{contactId}/numbers/{id}")
    public void deleteTopic(@PathVariable int id) {
      numbersService.deleteNumber(id);
    }

}
