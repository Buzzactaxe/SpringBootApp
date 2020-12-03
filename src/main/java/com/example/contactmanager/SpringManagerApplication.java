package com.example.contactmanager;

import com.example.contactmanager.model.persistence.Ui;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringManagerApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(SpringManagerApplication.class, args);
    }
    @Autowired
    private Ui ui;

    @Override
    public void run(String... args) {
        ui.showMainMenuUi();
    }
}
