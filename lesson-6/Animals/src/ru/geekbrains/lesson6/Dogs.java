package ru.geekbrains.lesson6;

public class Dogs extends Animals {

    public Dogs(String name, double runDistance, double swimDistance, double jumpHeight) {
        super(name, runDistance, swimDistance, jumpHeight);
    }

    public void dogPresent() {
        System.out.println(String.format("\n%s is a dog", name));
    }
}
