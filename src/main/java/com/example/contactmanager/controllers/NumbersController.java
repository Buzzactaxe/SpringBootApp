package com.example.contactmanager.controllers;


import com.example.contactmanager.model.api.NumbersResource;
import com.example.contactmanager.model.persistence.Numbers;
import com.example.contactmanager.service.NumbersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

//Swagger Mapper
@EnableSwagger2
@RequestMapping("/api")
@RestController
public class NumbersController {

    @Autowired
    private NumbersService numbersService;

    //Get
    @RequestMapping("/numbers")
    public ResponseEntity<List<NumbersResource>> getAllNumbers() {

        List<NumbersResource> numbersResources = new ArrayList<>();
        for (Numbers numbers : numbersService.getAllNumbers()) {
            numbersResources.add(new NumbersResource((numbers.getN_id()),
                    numbers.getHomeNumber(),
                    numbers.getMobileNumber()));
        }
        return new ResponseEntity<>(numbersResources, HttpStatus.OK);
    }

    //Get
    @RequestMapping("/numbers/{id}")
    public Numbers getId(@PathVariable int id) {
        return numbersService.getNumber(id);
    }

    //Post
    @RequestMapping(method = RequestMethod.POST, value = "/numbers/{id}")
    public void addNumber(@RequestBody Numbers n) {
        numbersService.addNumber(n);
    }

    //PUT
    @RequestMapping(method = RequestMethod.PUT, value = "/numbers/{id}")
    public void updateNumber(@RequestBody Numbers n, @PathVariable int id) {
        numbersService.updateNumber(id, n);
    }

    //PATCH / EDIT
    @PatchMapping("/numbers/{id}")
    public void patchNumber(@PathVariable int id, Map<Object, Object> fields){
        Numbers number = numbersService.getNumber(id);
        fields.forEach((k, v) ->{
            Field field = ReflectionUtils.findField(Numbers.class, (String) k);
            field.setAccessible(true);
            ReflectionUtils.setField(field, number, v);
        });
        numbersService.updateNumber(id, number);
    }

    //DELETE
    @RequestMapping(method = RequestMethod.DELETE, value = "/numbers/{id}")
    public void deleteTopic(@PathVariable int id) {
        numbersService.deleteNumber(id);
    }
}
