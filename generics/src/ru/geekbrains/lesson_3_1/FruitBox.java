package ru.geekbrains.lesson_3_1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class FruitBox <T extends Fruit> {

    private ArrayList<T> ourFruits;

    public FruitBox(T... ourFruits) {

        ArrayList<T> newOurFruits = new ArrayList<T>(Arrays.asList(ourFruits));
        this.ourFruits = newOurFruits;
    }

    public void addFruit (T... ourFruits) {
        this.ourFruits.addAll(Arrays.asList(ourFruits));

    }

    public ArrayList<T> getFruits() {
        return new ArrayList<T>(ourFruits);
    }

    public float checkWeight() {
        float weight = 0;

        if (ourFruits.size() == 0)  {
            return 0;
        } else {
            for (int i =0; i<ourFruits.size(); i++) {
                weight = weight + ourFruits.get(i).getFruitWeight();
            }
            return weight;
            }
        }

    public boolean compareFruitBox(FruitBox newBox) {
        return this.checkWeight() == newBox.checkWeight();
    }

    public void put(FruitBox<T> newBox) {
        newBox.ourFruits.addAll(this.ourFruits);
        ourFruits.clear();
    }
}
