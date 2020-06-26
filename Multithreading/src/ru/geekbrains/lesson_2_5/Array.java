package ru.geekbrains.lesson_2_5;

abstract class Array {

    private final int size = 10000000;
    public float[] basicArray = new float[size];
    private final int half = size/2;


    public int getHalf() {
        return half;
    }

    public int getSize() {

        return size;
    }

    public float[] getBasicArray() {

        return basicArray;
    }

}
