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
            catsInfoList(catsList());
            dogsInfoList(dogsList());
        } else if (scanChoice == 2) {
            checkCatSkills(catsList());

        } else if (scanChoice == 3) {
            checkDogSkills(dogsList());
        } else {
            startApp();
        }
    }


    public static Cats[] catsList() {

        Cats[] cats = new Cats[3];
        cats[0] = new Cats("Boris", 200, 0, 2);
        cats[1] = new Cats("Alice", 500, 0, 2.5);
        cats[2] = new Cats("Polina", 370, 0, 3);
        return cats;
    }

    public static void catsInfoList(Cats cats[]) {

        for (int i = 0; i < cats.length; i++) {
            cats[i].catPresent();
            cats[i].run();
            cats[i].jump();
            cats[i].swim();
        }
    }

    public static void checkCatSkills(Cats cats[]) {

        int i;
        Scanner scanner = new Scanner(System.in);
        System.out.println(String.format("Please, choose a cat.\n1 - Cat %s.\n2 - Cat %s.\n3 - Cat %s.",
                cats[0].getName(), cats[1].getName(), cats[2].getName()));
        int scanChooseCat = scanner.nextInt() - 1;
        if (scanChooseCat > 3) {
            checkCatSkills(catsList());
        } else if (scanChooseCat < 0) {
            checkCatSkills(catsList());
        } else {
            i = scanChooseCat;
            double runDistance = cats[i].getRunDistance();
            double jumpHeight = cats[i].getJumpHeight();
            double swimDistance = cats[i].getSwimDistance();
            System.out.println("What skills you want check?\n1 - skill to run \n2 - skill to jump \n3 - skill to swim");
            int skillNumber = scanner.nextInt();
            if (skillNumber == 1) {
                System.out.println("Input run distance in meters.");
                double newRunDistance = scanner.nextDouble();
                if (newRunDistance > runDistance) {
                    System.out.println(String.format("Cat can't run so far. Max run distance for cat %s meters.", runDistance));
                } else {
                    System.out.println(String.format("Great, its true. Max run distance for cat %s meters.", runDistance));
                }
            } else if (skillNumber == 2) {
                System.out.println("Input jump height in meters.");
                double newJumpHeight = scanner.nextDouble();
                if (newJumpHeight > jumpHeight) {
                    System.out.println(String.format("Cat can't jump so far. Max jump height for cat %s meters.", jumpHeight));
                } else {
                    System.out.println(String.format("Great, its true. Max jump height for cat %s meters.", jumpHeight));
                }
            } else if (skillNumber == 3) {
                System.out.println("Input swim distance in meters");
                double newSwimDistance = scanner.nextDouble();
                if (newSwimDistance > 0) {
                    System.out.println("Cat afraid water. He won't do it.");
                } else {
                    System.out.println("Cat afraid water. He won't do it.");
                }
            } else {
                checkCatSkills(catsList());
            }
        }
    }

    public static Dogs dogsList() {

        Dogs dog1 = new Dogs("Shurik", 500, 10, 0.5);
        return dog1;
    }

    public static void dogsInfoList(Dogs dog1) {

        dog1.dogPresent();
        dog1.run();
        dog1.jump();
        dog1.swim();
    }

    public static void checkDogSkills(Dogs Dog1) {

        double runDistance = Dog1.getRunDistance();
        double jumpHeight = Dog1.getJumpHeight();
        double swimDistance = Dog1.getSwimDistance();
        Scanner scanner = new Scanner(System.in);
        System.out.println("What skills you want check?\n1 - skill to run \n2 - skill to jump \n3 - skill to swim");
        int skillNumber = scanner.nextInt();
        if (skillNumber == 1) {
            System.out.println("Input run distance in meters.");
            double newRunDistance = scanner.nextDouble();
            if (newRunDistance > runDistance) {
                System.out.println(String.format("Dog can't run so far. Max run distance for dog %s meters.", runDistance));
            } else {
                System.out.println(String.format("Great, its true. Max run distance for dog %s meters.", runDistance));
            }
        } else if (skillNumber == 2) {
            System.out.println("Input jump height in meters.");
            double newJumpHeight = scanner.nextDouble();
            if (newJumpHeight > jumpHeight) {
                System.out.println(String.format("Dog can't jump so far.Max jump height for dog %s meters.", jumpHeight));
            } else {
                System.out.println(String.format("Great, its true. Max jump height for dog %s meters.", jumpHeight));
            }
        } else if (skillNumber == 3) {
            System.out.println("Input swim distance in meters");
            double newSwimDistance = scanner.nextDouble();
            if (newSwimDistance > swimDistance) {
                System.out.println(String.format("Dog can't swim so far.Max swim distance for dog %s meters.", swimDistance));
            } else {
                System.out.println(String.format("Great, its true. Max swim distance for dog %s meters.", swimDistance));
            }
        } else {
            checkDogSkills(dogsList());
        }
    }
}
