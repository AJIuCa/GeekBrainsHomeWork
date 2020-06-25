package ru.geekbrains.lesson_2_5;

abstract class Array {


    private final int size = 1000000;
    public float[] basicArray = new float[size];

    public int getSize() {
        return size;
    }

    public float[] getBasicArray() {
        return basicArray;
    }

    abstract long checkTime();
}
