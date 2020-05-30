package ru.geekbrains.lesson6;

public class Cats extends Animals {

    public Cats(String name, double runDistance, double swimDistance, double jumpHeight) {
        super(name, runDistance, swimDistance, jumpHeight);
    }

    public void catPresent() {
        System.out.println(String.format("\n%s is a cat", this.name));
    }

    @Override
    public void swim() {
        System.out.println(String.format("%s can swim, but he doesn't do it. He is afraid water.", this.name));
    }

}
