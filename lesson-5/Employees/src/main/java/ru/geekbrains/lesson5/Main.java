package ru.geekbrains.lesson5;



//  * Создать класс "Сотрудник" с полями: ФИО, должность, email, телефон, зарплата, возраст;
//  * Конструктор класса должен заполнять эти поля при создании объекта;
//  * Внутри класса «Сотрудник» написать метод, который выводит информацию об объекте в консоль;
//  * Создать массив из 5 сотрудников
//Пример:
//  Person[] persArray = new Person[5]; // Вначале объявляем массив объектов
//  persArray[0] = new Person("Ivanov Ivan", "Engineer", "ivivan@mailbox.com", "892312312", 30000, 30);
//  потом для каждой ячейки массива задаем объект
//  persArray[1] = new Person(...);
//  ...
//  persArray[4] = new Person(...);
//
//  * С помощью цикла вывести информацию только о сотрудниках старше 40 лет;

public class Main {

    public static void main(String[] args) {

        employeeFiles();

    }

    public static void employeeFiles() {

        Employees[] employees = new Employees[5];

        employees[0] = new Employees("Yagodka", "Andrei", "Viktorovich", 19,
                "Student", 7.500, "nagibator93@mail.com", "909 333 65 66");
//        employees[0].employeeFile();

        employees[1] = new Employees("Karpov", "Vitalii", "Igorevich", 43,
                "Guard", 67.300, "fishermen1978@mail.net", "916 325 69 82");
//        employees[1].employeeFile();

        employees[2] = new Employees("Karnov", "Vladislax", "Nikolaevich", 28,
                "System administrator", 80.000, "kinaved@mail.com", "906 481 26 17");
//        employees[2].employeeFile();

        employees[3] = new Employees("Kydasheva", "Arina", "Nikolaevna", 31,
                "Аccountant ", 75.700, "fishermen1978@mail.net", "909 932 12 45");
//        employees[3].employeeFile();

        employees[4] = new Employees("Ivolgin", "Sergei", "Sergeevich", 47,
                "Driver", 70.000, "fishermen1978@mail.net", "906 138 86 30");
//        employees[4].employeeFile();


        System.out.println("\nList of employees over 40 years.\n _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _  \n");

        if (employees[0].age > 40) {
            employees[0].employeeFile();
        }
        if (employees[1].age > 40) {
            employees[1].employeeFile();
        }
        if (employees[2].age > 40) {
            employees[2].employeeFile();
        }
        if (employees[3].age > 40) {
            employees[3].employeeFile();
        }
        if (employees[4].age > 40) {
            employees[4].employeeFile();
        }
    }
}
