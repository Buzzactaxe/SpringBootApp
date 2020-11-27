package com.example.contactmanager.controllers;



import com.example.contactmanager.model.Numbers;
import com.example.contactmanager.service.NumbersDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class NumbersController {

   @Autowired
  private NumbersDao numbersDao;

   //Get
    @RequestMapping("/contacts/{contactId}/numbers")
    public List<Numbers> getAllNumbers(@PathVariable int id){
        return numbersDao.getAllNumbers(id);
    }

    //Get
    @RequestMapping("contacts/{contactId}/numbers/{id}")
    public Numbers getId(@PathVariable int id){
        return numbersDao.getNumber(id);
    }

    //Post
    @RequestMapping(method = RequestMethod.POST, value="/contacts/{contactId}/numbers/{id}")
    public void addNumber(@RequestBody Numbers n) {
        numbersDao.addNumber(n);
    }

    //PUT
    @RequestMapping(method = RequestMethod.PUT, value="/contacts/{contactId}/numbers/{id}")
    public void updateNumber(@RequestBody Numbers n, @PathVariable int id) {
      numbersDao.updateNumber(id, n);

    }

    //DELETE
    @RequestMapping(method = RequestMethod.DELETE, value="/contacts/{contactId}/numbers/{id}")
    public void deleteTopic(@PathVariable int id) {
      numbersDao.deleteNumber(id);
    }

}
