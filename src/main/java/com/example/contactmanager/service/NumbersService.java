package com.example.contactmanager.service;

import com.example.contactmanager.model.persistence.Numbers;
import com.example.contactmanager.repository.NumbersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class NumbersService {
    @Autowired
    private NumbersRepository numbersRepository;

    public List<Numbers> getAllNumbers() {
        List<Numbers> numbers = new ArrayList<>();
        numbersRepository.findAll().forEach(numbers::add);
        return numbers;
    }


    public void addNumber(Numbers n){
        numbersRepository.save(n);
    }

    public Numbers getNumber(int id){
        return numbersRepository.findById(id).get();
    }

    public void updateNumber(int id, Numbers n){
        numbersRepository.save(n);
    }

    public void deleteNumber(int id){
        numbersRepository.deleteById(id);
    }
}
