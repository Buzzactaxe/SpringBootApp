package com.example.contactmanager.service;


import com.example.contactmanager.model.Numbers;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NumbersRepository extends JpaRepository<Numbers, Integer> {


}
