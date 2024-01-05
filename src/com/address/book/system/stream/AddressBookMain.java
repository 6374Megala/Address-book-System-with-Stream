package com.address.book.system.stream;

import java.util.List;
import java.util.Scanner;

public class AddressBookMain {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        AddressBook addressBook = new AddressBook();

        while (true) {
            displayMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addContact(addressBook);
                    break;
                case 2:
                    displaySortedByCity(addressBook);
                    break;
                case 3:
                    displaySortedByState(addressBook);
                    break;
                case 4:
                    displaySortedByZip(addressBook);
                    break;
                case 5:
                    displayAllContacts(addressBook);
                    break;
                case 0:
                    System.out.println("Exiting the program. Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void displayMenu() {
        System.out.println("\nMenu:");
        System.out.println("1. Add Contact");
        System.out.println("2. Display Contacts Sorted by City");
        System.out.println("3. Display Contacts Sorted by State");
        System.out.println("4. Display Contacts Sorted by Zip");
        System.out.println("5. Display All Contacts");
        System.out.println("0. Exit");
        System.out.print("Enter your choice: ");
    }

    private static void addContact(AddressBook addressBook) {
        System.out.println("\nAdding a new contact:");

        System.out.print("Enter first name: ");
        String firstName = scanner.nextLine();

        System.out.print("Enter last name: ");
        String lastName = scanner.nextLine();

        System.out.print("Enter address: ");
        String address = scanner.nextLine();

        System.out.print("Enter city: ");
        String city = scanner.nextLine();

        System.out.print("Enter state: ");
        String state = scanner.nextLine();

        System.out.print("Enter zip: ");
        String zip = scanner.nextLine();

        System.out.print("Enter phone number: ");
        String phoneNumber = scanner.nextLine();

        System.out.print("Enter email: ");
        String email = scanner.nextLine();

        Contact newContact = new Contact(firstName, lastName, address, city, state, zip, phoneNumber, email);
        addressBook.addContact(newContact);

        System.out.println("Contact added successfully!");
    }

    private static void displaySortedByCity(AddressBook addressBook) {
        List<Contact> sortedContacts = addressBook.getContactsSortedByCity();
        displaySortedContacts("City", sortedContacts);
    }

    private static void displaySortedByState(AddressBook addressBook) {
        List<Contact> sortedContacts = addressBook.getContactsSortedByState();
        displaySortedContacts("State", sortedContacts);
    }

    private static void displaySortedByZip(AddressBook addressBook) {
        List<Contact> sortedContacts = addressBook.getContactsSortedByZip();
        displaySortedContacts("Zip", sortedContacts);
    }

    private static void displayAllContacts(AddressBook addressBook) {
        addressBook.displayContacts();
    }

    private static void displaySortedContacts(String sortBy, List<Contact> sortedContacts) {
        System.out.println("\nContacts Sorted by " + sortBy + ":");
        if (sortedContacts.isEmpty()) {
            System.out.println("No contacts found.");
        } else {
            sortedContacts.forEach(contact -> System.out.println(contact));
        }
    }
}
