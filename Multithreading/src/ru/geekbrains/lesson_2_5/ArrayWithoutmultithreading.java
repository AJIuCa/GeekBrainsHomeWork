package ru.geekbrains.lesson_2_5;

public class ArrayWithoutmultithreading extends Array {


    public float[] fill() {

        for (int i = 0; i < getSize(); i++) {
            basicArray[i] = 1;
        }
        return basicArray;
    }


    public void checkTime() {

        fill();

        long start = System.currentTimeMillis();

        for (int j = 0; j < getSize(); j++) {
            basicArray[j] = (float) (basicArray[j] * Math.sin(0.2f + j / 5) * Math.cos(0.2f + j / 5) * Math.cos(0.4f + j / 2));
        }

        long end = System.currentTimeMillis();
        System.out.println("Time for single threading method = " + (end - start));

    }
}
