package ru.geekbrains.lesson7;

//  1. Расширить задачу про котов и тарелки с едой.
//  2. Сделать так, чтобы в тарелке с едой не могло получиться отрицательного количества еды
//      (например, в миске 10 еды, а кот пытается покушать 15-20).
//  3. Каждому коту нужно добавить поле сытость (когда создаем котов, они голодны). Если коту удалось покушать
//      (хватило еды), сытость = true.
//  4. Считаем, что если коту мало еды в тарелке, то он её просто не трогает, то есть не может быть наполовину сыт
//      (это сделано для упрощения логики программы).
//  5. Создать массив котов и тарелку с едой, попросить всех котов покушать из этой тарелки и потом вывести
//      информацию о сытости котов в консоль.
//  6. Добавить в тарелку метод, с помощью которого можно было бы добавлять еду в тарелку.

import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        startApp();
    }

    public static void startApp() {

        catFeeding(cats(), bowl());
    }

    public static Cats[] cats() {
        Cats[] cats = new Cats[3];
        cats[0] = new Cats("Boris", 7, 0);
        cats[1] = new Cats("Alice", 6, 0);
        cats[2] = new Cats("Polina", 4, 0);
        return cats;
    }

    public static Bowl bowl() {
        Bowl bowl = new Bowl(50);
        return bowl;
    }

    public static void catFeeding(Cats cats[], Bowl bowl) {
        int eatCircle;
        System.out.println("Do you want feed a cats? If YES input 1. If NO input any other number.");
        eatCircle = scanner.nextInt();
        while (eatCircle == 1) {
            for (int i = 0; i < cats.length; i++) {
                if (bowl.getFood() > cats[i].getAppetite()) {
                    cats[i].eat(bowl);
                    cats[i].setHunger(cats[i].getHunger() + cats[i].getAppetite());
                } else if (cats[i].getAppetite() > bowl.getFood()) {
                    System.out.printf("\n%s won't it. It's not enough food", cats[i].getName());
                }
            }
            for (int k = 0; k < cats.length; k++) {
                System.out.print("\n" + cats[k].getName() + " is full on " + ((cats[k].getHunger() * 100) / 10) + "%.");
            }
            if (bowl.getFood() < 21) {
                System.out.println("\nMaybe you want refill a bowl? If you want INPUT 1. If NO input any other number");
                int refill = scanner.nextInt();
                if (refill == 1) {
                    bowl.refillFood();
                }
            }
            bowl.checkBowl();
            System.out.println("\nDo you want feed cat again? If YES input 1. If NO input any other number.");
            eatCircle = scanner.nextInt();
        }
    }
}
