package ru.geekbrains.lesson5;

public class Employees {


    private String surname;
    private String name;
    private String middleName;
    private int age;
    private String position;
    private double salary;
    private String eMail;
    private String phoneNumber;

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

    public String getSurname() {
        return surname;
    }

    public String getName() {
        return name;
    }

    public String getMiddleName() {
        return middleName;
    }

    public int getAge() {
        return age;
    }

    public String getPosition() {
        return position;
    }

    public double getSalary() {
        return salary;
    }

    public String geteMail() {
        return eMail;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }


    void employeeFile() {
        System.out.println("Personal data of the employee.\n- Surname: " + this.surname + "\n- Name: " + this.name +
                "\n- Middle name: " + this.middleName + "\n- Age: " + this.age + "\n- Position: " + this.position +
                "\n- Salary: " + String.format("%.3f", this.salary) + " ₽" + "\n- E-mail: " + this.eMail +
                "\n- Phone number: (+7)" + this.phoneNumber + "\n___________________________________");

    }
}
