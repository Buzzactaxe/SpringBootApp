package com.example.contactmanager.model.persistence;


import com.example.contactmanager.service.ConsoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;


import java.util.Scanner;

@Component
public class Ui {
    @Autowired
    private ConsoleService consoleService;

    public void showMainMenuUi() {
        System.out.println(
                "\n▐▓█▀▀▀▀▀▀▀▀▀█▓▌░▄▄▄▄▄░\n" +
                        "▐▓█░░▀░░▀▄░░█▓▌░█▄▄▄█░\n" +
                        "▐▓█░░▄░░▄▀░░█▓▌░█▄▄▄█░\n" +
                        "▐▓█▄▄▄▄▄▄▄▄▄█▓▌░█████░\n" +
                        "░░░░▄▄███▄▄░░░░░█████░");
        String intro = "\n" + "0 = [ All Contacts ]\n" + "\n" + "1 = [ Find Contact By ID ]\n" + "2 = [ Contacts Age ]\n" + "\n3 = [ Add Contact ] \n" + "4 = [ Delete Contact ]\n\n" + "5 = [ Choose Data Type ] \n" + "Exit = [ Exit ] \n";
        System.out.println(intro);
        try  {
            Scanner scanner = new Scanner(System.in);
            var userInput = StringUtils.capitalize(scanner.nextLine());
            switch (userInput) {
                case "0":
                    showAllContacts();
                    break;

                case "1":
                    findContactByIdMenu();
                    break;

                case "2":
                    showContactsAge(scanner);
                    break;

                case "3":
                    addNewContactMenu();
                    break;

                case "4":
                    deleteContactMenu();
                    break;

                case "5":
                    getUiMenu();
                    break;

                case "Exit":
                    System.out.println("༼ つ ◕_◕ ༽つ You left the project, Goodbye!!");
                    System.exit(0);
                    break;
                default:
                    showMainMenuUi();
                    break;
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    private void getUiMenu() {
    }

    private void deleteContactMenu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter  ID of Contact you want to delete");
        var customerId = scanner.nextInt();
        consoleService.deleteFromId(customerId);
        System.out.println("contact deleted");
        showMainMenuUi();
    }

    private void addNewContactMenu() {
        var scanner = new Scanner(System.in);
        System.out.println("( ͡° ͜ʖ ͡°) Please insert the details required to add a new contact\n");
        System.out.println("유 Name");
        //Add Contact name and surname
        var addName =StringUtils.capitalize(scanner.nextLine());
        while (addName.isBlank()) {
            System.out.println("You may not continue without a first name for new contact");
            addName = scanner.nextLine();
        }
        //Add Contact surname
        System.out.println("유 Surname");
        var addSurname = StringUtils.capitalize(scanner.nextLine());
        while (addSurname.isBlank()) {
            System.out.println("You may not continue without a Surname for new contact");
            addSurname = StringUtils.capitalize(scanner.nextLine());
        }
        //Add Contact age
        System.out.println("유 Age (num format)");
        var addContactAge = scanner.nextInt();


        //Add Home Phone number
        System.out.println("☏ Home Phone Number");
        var addHomePhone = scanner.next();

        //Add House number
        System.out.println("☏ Mobile Number");
        var addMobilePhone = scanner.next();


        Numbers contactNumbers = new Numbers(addHomePhone, addMobilePhone);
        Contact contact = new Contact(addName, addSurname, addContactAge, contactNumbers);
        consoleService.addContact(contact);
        System.out.println(
                "\n░░░░░░░░░░░░░░░░░░░░░░█████████░░░░░░░░░\n" +
                        "░░███████░░░░░░░░░░███▒▒▒▒▒▒▒▒███░░░░░░░\n" +
                        "░░█▒▒▒▒▒▒█░░░░░░░███▒▒▒▒▒▒▒▒▒▒▒▒▒███░░░░\n" +
                        "░░░█▒▒▒▒▒▒█░░░░██▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒██░░\n" +
                        "░░░░█▒▒▒▒▒█░░░██▒▒▒▒▒██▒▒▒▒▒▒██▒▒▒▒▒███░\n" +
                        "░░░░░█▒▒▒█░░░█▒▒▒▒▒▒████▒▒▒▒████▒▒▒▒▒▒██\n" +
                        "░░░█████████████▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒██\n" +
                        "░░░█▒▒▒▒▒▒▒▒▒▒▒▒█▒▒▒▒▒▒▒▒▒█▒▒▒▒▒▒▒▒▒▒▒██\n" +
                        "░██▒▒▒▒▒▒▒▒▒▒▒▒▒█▒▒▒██▒▒▒▒▒▒▒▒▒▒██▒▒▒▒██\n" +
                        "██▒▒▒███████████▒▒▒▒▒██▒▒▒▒▒▒▒▒██▒▒▒▒▒██\n" +
                        "█▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒█▒▒▒▒▒▒████████▒▒▒▒▒▒▒██\n" +
                        "██▒▒▒▒▒▒▒▒▒▒▒▒▒▒█▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒██░\n" +
                        "░█▒▒▒███████████▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒██░░░\n" +
                        "░██▒▒▒▒▒▒▒▒▒▒████▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒█░░░░░\n" +
                        "░░████████████░░░█████████████████░░░░░░" +

                        "\n(¯`·._.· " + contact.getName().toUpperCase() + " " + contact.getSurname().toUpperCase() + " WAS ADDED ·._.·´¯)");
        showMainMenuUi();

    }

    private void showContactsAge(Scanner scanner) {
    }

    private void findContactByIdMenu() {
    }

    private void showAllContacts() {
        var contactList = consoleService.getContactList();
        for (Contact contact : contactList) {
            System.out.println("| Contact ID: " + contact.getId() + "\n  Age: " + contact.toString() + "\n------|");
        }
    }

    public void test(){
        System.out.println("This is a test in the UI.class, we will see what you can write");
    }

}
