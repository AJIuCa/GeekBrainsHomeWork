package ru.geekbrains.lesson_2_5;

import java.util.Arrays;

public class ArrayWithMultithreading extends Array {

    public static float[] firstPartOfArray;
    public static float[] secondPartOfArray;

    float[] fillArray() {

        for (int i = 0; i < getSize(); i++) {
            basicArray[i] = 1;
        }

        return basicArray;
    }

    public void multiThreading() {

        fillArray();

        long startMultiThreading = System.currentTimeMillis();

        firstPartOfArray = new float[half];
        Thread thread1 = new Thread(() -> firstPartCalc(basicArray, 0, firstPartOfArray, 0, half));

        secondPartOfArray = new float[half];
        Thread thread2 = new Thread(() -> secondPartCalc(basicArray, half, secondPartOfArray, 0, half));

        thread1.start();
        thread2.start();

        long endMultithreading = System.currentTimeMillis();


        System.out.println("Time to multithreading method = " + (endMultithreading - startMultiThreading));

    }


    public float[] firstPartCalc(float[] source, int scrPos, float[] newMultiArray, int destPos, int lenght) {

        System.arraycopy(source, scrPos,newMultiArray, destPos, lenght);

        for (int i = 0; i < newMultiArray.length; i++) {
            newMultiArray[i] = (float) (newMultiArray[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }

        System.arraycopy(newMultiArray, 0, source, scrPos, lenght);

        for (int i = 0; i < newMultiArray.length; i++) {
            newMultiArray[i] = (float) (newMultiArray[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }

        System.arraycopy(newMultiArray, 0, basicArray, scrPos, lenght);

        return basicArray;

    }

    public float[]  secondPartCalc(float[] source, int scrPos, float[] newMultiArray, int destPos, int lenght) {

        System.arraycopy(source, scrPos, newMultiArray, destPos, lenght);

        for (int i = 0; i < newMultiArray.length; i++) {
            newMultiArray[i] = (float) (newMultiArray[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }

        System.arraycopy(newMultiArray, 0, source, scrPos, lenght);

        for (int i = 0; i < newMultiArray.length; i++) {
            newMultiArray[i] = (float) (newMultiArray[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }

        System.arraycopy(newMultiArray, 0, basicArray, lenght, lenght);

        return basicArray;
    }
}


