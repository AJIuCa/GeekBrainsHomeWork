package ru.geekbrains.lesson6;

//        1. Создать классы Собака и Кот с наследованием от класса Животное (основаная задача находится в методичке)
//        2. Животные могут выполнять действия: бежать, плыть, перепрыгивать препятствие. В качестве параметра каждому
//          методу передается величина, означающая или длину препятствия (для бега и плавания), или высоту (для прыжков).
//        3. У каждого животного есть ограничения на действия (бег: кот 200 м., собака 500 м.; прыжок: кот 2 м.,
////          собака 0.5 м.; плавание: кот не умеет плавать, собака 10 м.).
//        4. При попытке животного выполнить одно из этих действий, оно должно сообщить результат в консоль.
//          (Например, dog1.run(150); -> результат: run: true)
//        5. * Добавить животным разброс в ограничениях. То есть у одной собаки ограничение на бег
//          может быть 400 м., у другой 600 м.

import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        startApp();

    }

    public static void startApp() {
        System.out.println("Please, make choice.\n1 - Animals skill list.\n2 - Check cat skills.\n3 - Check dog skills");
        Scanner scanner = new Scanner(System.in);
        int scanChoice = scanner.nextInt();
        if (scanChoice == 1) {
            catsList();
            dogsList();
        } else if (scanChoice == 2) {
            checkCatSkills();
        } else if (scanChoice == 3) {
            checkDogSkills();
        } else {
            startApp();
        }
    }

    public static Cats catsList() {

        Cats cat1 = new Cats("Boris", 200, 0, 2);
        cat1.catPresent();
        cat1.run();
        cat1.jump();
        cat1.swim();
        return cat1;
    }

    public static Dogs dogsList() {
        Dogs dog1 = new Dogs("Shurik", 500, 10, 0.5);
        dog1.dogPresent();
        dog1.run();
        dog1.jump();
        dog1.swim();
        return dog1;
    }

    public static void checkCatSkills(Cats cat1) {
        double runDistance = cat1.getRunDistance();
        double jumpHeight = cat1.getJumpHeight();
        Scanner scanner = new Scanner(System.in);
        System.out.println("What skills you want check?\n1 - skill to run \n2 - skill to jump \n3 - skill to swim");
        int skillNumber = scanner.nextInt();
        if (skillNumber == 1) {
            System.out.println("Input run distance in meters.");
            double newRunDistance = scanner.nextDouble();
            if (newRunDistance > runDistance) {
                System.out.println("Cat can't run so far.");
            } else {
                System.out.println("Not bad. Max run distance for cat 200 meters.");
            }
        } else if (skillNumber == 2) {
            System.out.println("Input jump height in meters.");
            double newJumpDistance = scanner.nextDouble();
            if (newJumpDistance > jumpHeight) {
                System.out.println("Cat can't jump so far.");
            } else {
                System.out.println("Not bad. Max jump height for cat 2 meters.");
            }
        } else if (skillNumber == 3) {
            System.out.println("Input swim distance in meters");
            double newSwimDistance = scanner.nextDouble();
            if (newSwimDistance > 0) {
                System.out.println("Cat afraid water. He won't do it.");
            } else {
                System.out.println("Cat afraid water. He won't do it.");
            }
        }
    }

    public static void checkDogSkills() {
    }
}
