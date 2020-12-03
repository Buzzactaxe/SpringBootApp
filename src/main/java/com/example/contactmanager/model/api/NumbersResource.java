package com.example.contactmanager.model.api;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;


@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
public class NumbersResource {

    private int n_id;
    private String homeNumber;
    private String mobileNumber;
}
