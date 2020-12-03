package com.example.contactmanager.model.persistence;

import com.fasterxml.jackson.annotation.*;
import lombok.*;

import javax.persistence.*;



@NoArgsConstructor
@ToString
@Data
@Entity
@Table(name = "numbers")
//@JsonIdentityInfo(
//        generator = ObjectIdGenerators.PropertyGenerator.class,
//        property = "n_id")
public class Numbers {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int n_id;
    @Column(name = "house_phone")
    private String homeNumber;
    @Column(name = "mobile_phone")
    private String mobileNumber;

//    @JsonManagedReference
//    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "numbers")
//    private Contact contact;

    public Numbers(String homeNumber, String mobileNumber) {
        this.homeNumber = homeNumber;
        this.mobileNumber = mobileNumber;
     //   this.contact = contact;
    }


    @Override
    public String toString() {
        return "Numbers{" +
                "homeNumber='" + homeNumber + '\'' +
                ", mobileNumber='" + mobileNumber + '\'' +
                '}';
    }
}
