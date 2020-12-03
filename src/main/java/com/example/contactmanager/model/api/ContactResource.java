package com.example.contactmanager.model.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ContactResource {

    private int id;
    private String name;
    private String surname;
    private int age;

    private NumbersResource numbers;

}