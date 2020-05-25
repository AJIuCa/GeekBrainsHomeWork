package ru.geekbrains.lesson5;

public class Employees {

    protected String surname;
    protected String name;
    protected String middleName;
    int age;
    String position;
    double salary;
    String eMail;
    String phoneNumber;

    Employees(String surname, String name, String middleName, int age, String position, double salary,
              String eMail, String phoneNumber) {
        this.surname = surname;
        this.name = name;
        this.middleName = middleName;
        this.age = age;
        this.position = position;
        this.salary = salary;
        this.eMail = eMail;
        this.phoneNumber = phoneNumber;
    }

    void employeeFile() {
        System.out.println("Personal data of the employee.\n- Surname: " + this.surname + "\n- Name: " + this.name +
                "\n- Middle name: " + this.middleName + "\n- Age: " + this.age + "\n- Position: " + this.position +
                "\n- Salary: " + String.format("%.3f", this.salary) + " ₽" + "\n- E-mail: " + this.eMail +
                "\n- Phone number: (+7)" + this.phoneNumber + "\n___________________________________");

    }
}
