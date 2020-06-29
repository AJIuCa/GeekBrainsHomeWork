package ru.geekbrains.lesson_2_5;

abstract class Array {

    private final int size = 1000000000;
    public float[] basicArray = new float[size];
    public final int half = size / 2;


    public int getSize() {
        return size;
    }

    public float[] getBasicArray() {

        return basicArray;
    }

}
