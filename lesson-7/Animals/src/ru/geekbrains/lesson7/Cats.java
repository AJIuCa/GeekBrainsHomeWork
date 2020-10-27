package ru.geekbrains.lesson7;

public class Cats {


    protected String name;
    protected int appetite;
    protected int hunger;

    public Cats(String name, int appetite, int hunger) {
        this.name = name;
        this.appetite = appetite;
        this.hunger = hunger;
    }

    public String getName() {
        return name;
    }

    public int getAppetite() {
        return appetite;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAppetite(int appetite) {
        this.appetite = appetite;
    }

    public void setHunger(int hunger) {
        this.hunger = hunger;
    }

    public int getHunger() {
        return hunger;
    }

    public void eat(Bowl bowl) {
        bowl.decreaseFood(appetite);
    }
}
