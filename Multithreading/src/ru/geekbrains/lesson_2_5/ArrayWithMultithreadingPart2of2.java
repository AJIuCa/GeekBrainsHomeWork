package ru.geekbrains.lesson_2_5;

import java.util.Arrays;

    public class ArrayWithMultithreadingPart2of2 extends Array implements Runnable {

    @Override
    public void run() {
        fillArray();
    }

    float[] fillArray() {

        for (int i = 0; i < getSize(); i++) {
            basicArray[i] = 1;
        }

        float[] pieceOfBasicArray2 = new float[getHalf()];

        System.arraycopy(basicArray, getHalf(), pieceOfBasicArray2, 0, getHalf());

        for (int j = 0; j < pieceOfBasicArray2.length; j++) {
            pieceOfBasicArray2[j] = (float) (pieceOfBasicArray2[j] * Math.sin(0.2f + j / 5) * Math.cos(0.2f + j / 5) * Math.cos(0.4f + j / 2));
        }

//        System.out.println("\n");
//        System.out.println(Arrays.toString(pieceOfBasicArray2));
//        System.out.println("\n");

        return pieceOfBasicArray2;
    }
}
