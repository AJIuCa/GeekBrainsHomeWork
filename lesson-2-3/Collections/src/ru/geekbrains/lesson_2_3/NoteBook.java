package ru.geekbrains.lesson_2_3;

import java.util.HashMap;
import java.util.HashSet;

public class NoteBook {

    // Values

    protected String surname;
    protected HashSet<String> phoneNumber;
    protected HashMap<String, HashSet<String>> phoneBook;

    // Getters

    public String getSurname () {

        return surname;
    }

    public HashSet<String> getPhoneNumber () {

        return phoneNumber;
    }

    public HashMap<String, HashSet<String>> getPhoneBook () {
        return phoneBook;
    }

    // Construktor


    public NoteBook(HashMap<String, HashSet<String>> phoneBook) {
        this.phoneBook = phoneBook;

    }

    // Method
    public void addContacts() {

        phoneBook.put(surname,phoneNumber);
    }
}
