package ru.geekbrains.lesson_2_5;

public class ArrayWithoutmultithreading extends Array {


    float[] checkTime() {

//        long start = System.currentTimeMillis();

        for (int i = 0; i < getSize(); i++) {
            basicArray[i] = 1;
        }


        for (int j = 0; j < getSize(); j++) {
            basicArray[j] = (float) (basicArray[j] * Math.sin(0.2f + j / 5) * Math.cos(0.2f + j / 5) * Math.cos(0.4f + j / 2));
        }

        long end = System.currentTimeMillis();

//        long totalTime = end - start;

//        System.out.println("Time for single threading method = " + totalTime);

        return basicArray;
    }

}
