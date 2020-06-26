package ru.geekbrains.lesson_2_5;

import java.util.Arrays;

public class ArrayWithMultithreadingPart1of2 extends Array implements Runnable {

    float[] packedArray = new float[getSize()];

    @Override
    public void run() {

        fillArray();
    }

    float[] fillArray() {

        for (int i = 0; i < getSize(); i++) {
            basicArray[i] = 1;
        }

            float[] pieceOfBasicArray1 = new float[getHalf()];

            System.arraycopy(basicArray, 0, pieceOfBasicArray1, 0, getHalf());


            for (int j = 0; j < pieceOfBasicArray1.length; j++) {
                pieceOfBasicArray1[j] = (float) (pieceOfBasicArray1[j] * Math.sin(0.2f + j / 5) * Math.cos(0.2f + j / 5) * Math.cos(0.4f + j / 2));
            }

//            System.out.println("\n");
//            System.out.println(Arrays.toString(pieceOfBasicArray1));
//            System.out.println("\n");

//             System.arraycopy(pieceOfBasicArray1, 0, packedArray , 0, getHalf());

            return packedArray;
        }

    }


