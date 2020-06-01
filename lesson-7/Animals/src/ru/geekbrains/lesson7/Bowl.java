package ru.geekbrains.lesson7;


import java.util.Scanner;

public class Bowl {

    Scanner scanner = new Scanner(System.in);

    protected int food;

    public Bowl (int food) {
        this.food = food;
    }

    public int getFood() {
        return food;
    }

    public void setFood(int food) {
        this.food = food;
    }

    public void decreaseFood (int i) {
        this.food = food - i;
    }

    public void checkBowl () {
        System.out.printf("\nBowl have %s point of food", this.food);
    }
    public void refillFood () {
        int refill = scanner.nextInt();
        this.food += refill;
    }

}
