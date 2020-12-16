package com.example.contactmanager.model.persistence;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data

@Entity
@Table(name = "contacts")
public class Contact {
    @Id
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "surname")
    private String surname;
    @Column(name = "age")
    private int age;

//    @JsonBackReference
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "n_id", nullable = false)
    private Numbers numbers;

    public Contact(String name, String surname, Integer age, Numbers numbers) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.numbers = numbers;
    }

    public Contact(String name, String surname, int age) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", numbers=" + numbers +
                '}';
    }
}