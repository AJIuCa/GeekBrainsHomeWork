package ru.geekbrains.lesson6;

import java.text.Format;

public abstract class Animals {


    protected String name;
    protected double runDistance;
    protected double swimDistance;
    protected double jumpHeight;


    public Animals(String name, double runDistance, double swimDistance, double jumpHeight) {
        this.name = name;
        this.runDistance = runDistance;
        this.swimDistance = swimDistance;
        this.jumpHeight = jumpHeight;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRunDistance(double runDistance) {
        this.runDistance = runDistance;
    }

    public void setSwimDistance(double swimDistance) {
        this.swimDistance = swimDistance;
    }

    public void setJumpHeight(double jumpHeight) {
        this.jumpHeight = jumpHeight;
    }

    public String getName() {
        return name;
    }

    public double getRunDistance() {
        return runDistance;
    }

    public double getSwimDistance() {
        return swimDistance;
    }

    public double getJumpHeight() {
        return jumpHeight;
    }


    public void run() {
        System.out.println(String.format("%s can run. Max distance %s meters.", this.name, this.runDistance));

    }

    public void jump() {
        System.out.println(String.format("%s can't jump over %s meters.", this.name, this.jumpHeight));

    }

    public void swim() {
        System.out.println(String.format("%s can swim. Max distance %s meters.", name, swimDistance));

    }
}
