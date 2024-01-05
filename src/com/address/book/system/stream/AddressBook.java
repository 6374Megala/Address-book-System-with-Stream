package com.address.book.system.stream;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class AddressBook {

    private List<Contact> contacts;

    public AddressBook() {
        this.contacts = new ArrayList<>();
    }

    public void addContact(Contact contact) {
        contacts.add(contact);
    }

    public List<Contact> getContactsSortedByCity() {
        return contacts.stream()
                .sorted(Comparator.comparing(Contact::getCity))
                .collect(Collectors.toList());
    }

    public List<Contact> getContactsSortedByState() {
        return contacts.stream()
                .sorted(Comparator.comparing(Contact::getState))
                .collect(Collectors.toList());
    }

    public List<Contact> getContactsSortedByZip() {
        return contacts.stream()
                .sorted(Comparator.comparing(Contact::getZip))
                .collect(Collectors.toList());
    }

    public void displayContacts() {
        if (contacts.isEmpty()) {
            System.out.println("No contacts found.");
        } else {
            System.out.println("Address Book Entries:");
            contacts.forEach(contact -> System.out.println(contact));
        }
    }
}


