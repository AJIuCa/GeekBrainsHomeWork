package ru.geekbrains.lesson_2_3;

public class PhoneBook {


    protected Integer phoneNumber;
    protected String surname;

    public PhoneBook(String surname, Integer phoneNumber) {
        this.phoneNumber = phoneNumber;
        this.surname = surname;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public String getSurname() {
        return surname;
    }

    public int setPhoneNumber() {
        return phoneNumber;
    }

    public String setSurname() {
        return surname;
    }
    public void showInfo () {
        System.out.println(String.format("%s - %s.", surname,phoneNumber));
    }
}
