package ru.geekbrains.lesson_2_5;

public class ArrayWithMultithreading extends Array {


    @Override
    long checkTime() {

        float[] pieceOfBasicArray1 = new float[basicArray.length / 5];
        float[] pieceOfBasicArray2 = new float[basicArray.length / 5];
        float[] pieceOfBasicArray3 = new float[basicArray.length / 5];
        float[] pieceOfBasicArray4 = new float[basicArray.length / 5];
        float[] pieceOfBasicArray5 = new float[basicArray.length / 5];


        for (int i = 0; i < getSize(); i++) {
            basicArray[i] = 1;
        }

        long start = System.currentTimeMillis();

        System.arraycopy(basicArray, 0, pieceOfBasicArray1, 0, pieceOfBasicArray1.length);
        System.arraycopy(basicArray, pieceOfBasicArray1.length, pieceOfBasicArray2, 0, pieceOfBasicArray2.length);
        System.arraycopy(basicArray, pieceOfBasicArray2.length, pieceOfBasicArray3, 0, pieceOfBasicArray3.length);
        System.arraycopy(basicArray, pieceOfBasicArray3.length, pieceOfBasicArray4, 0, pieceOfBasicArray4.length);
        System.arraycopy(basicArray, pieceOfBasicArray4.length, pieceOfBasicArray5, 0, pieceOfBasicArray5.length);


        for (int j = 0; j < pieceOfBasicArray1.length; j++) {
            pieceOfBasicArray1[j] = (float) (pieceOfBasicArray1[j] * Math.sin(0.2f + j / 5) * Math.cos(0.2f + j / 5) * Math.cos(0.4f + j / 2));
        }
        for (int j = 0; j < pieceOfBasicArray2.length; j++) {
            pieceOfBasicArray2[j] = (float) (pieceOfBasicArray2[j] * Math.sin(0.2f + j / 5) * Math.cos(0.2f + j / 5) * Math.cos(0.4f + j / 2));
        }
        for (int j = 0; j < pieceOfBasicArray3.length; j++) {
            pieceOfBasicArray3[j] = (float) (pieceOfBasicArray3[j] * Math.sin(0.2f + j / 5) * Math.cos(0.2f + j / 5) * Math.cos(0.4f + j / 2));
        }
        for (int j = 0; j < pieceOfBasicArray4.length; j++) {
            pieceOfBasicArray4[j] = (float) (pieceOfBasicArray4[j] * Math.sin(0.2f + j / 5) * Math.cos(0.2f + j / 5) * Math.cos(0.4f + j / 2));
        }
        for (int j = 0; j < pieceOfBasicArray5.length; j++) {
            pieceOfBasicArray5[j] = (float) (pieceOfBasicArray5[j] * Math.sin(0.2f + j / 5) * Math.cos(0.2f + j / 5) * Math.cos(0.4f + j / 2));
        }

        System.arraycopy(pieceOfBasicArray1, 0, basicArray, 0, pieceOfBasicArray1.length);
        System.arraycopy(pieceOfBasicArray2, 0, basicArray, pieceOfBasicArray1.length, pieceOfBasicArray2.length);
        System.arraycopy(pieceOfBasicArray3, 0, basicArray, pieceOfBasicArray2.length, pieceOfBasicArray3.length);
        System.arraycopy(pieceOfBasicArray4, 0, basicArray, pieceOfBasicArray3.length, pieceOfBasicArray4.length);
        System.arraycopy(pieceOfBasicArray5, 0, basicArray, pieceOfBasicArray4.length, pieceOfBasicArray5.length);

        long end = System.currentTimeMillis();

        long totalTime = end - start;

        System.out.println("Time for multithreading method = " + totalTime);

        return totalTime;
    }
}
