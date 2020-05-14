package ru.geekbrains.lesson2;


//  1. Задать целочисленный массив, состоящий из элементов 0 и 1. Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ].
//      С помощью цикла и условия заменить 0 на 1, 1 на 0;
//  2. Задать пустой целочисленный массив размером 8. С помощью цикла заполнить его значениями 0 3 6 9 12 15 18 21;
//  3. Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ] пройти по нему циклом, и числа меньшие 6 умножить на 2;
//  4. Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое), и с помощью
//      цикла(-ов) заполнить его диагональные элементы единицами;
//  5. ** Задать одномерный массив и найти в нем минимальный и максимальный элементы (без помощи интернета);
//  6. ** Написать метод, в который передается не пустой одномерный целочисленный массив, метод должен вернуть true,
//      если в массиве есть место, в котором сумма левой и правой части массива равны.
//      Примеры: checkBalance([2, 2, 2, 1, 2, 2, || 10, 1]) → true, checkBalance([1, 1, 1, || 2, 1]) → true,
//      граница показана символами ||, эти символы в массив не входят.
//  7. **** Написать метод, которому на вход подается одномерный массив и
//      число n (может быть положительным, или отрицательным), при этом метод должен сместить все элементымассива
//      на n позиций. Для усложнения задачи нельзя пользоваться вспомогательными массивами.

import java.time.chrono.MinguoChronology;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class StudingArrays {

    public static void main(String[] args) {
        arrayInvert();
        fillingArray();
        arrayWithNumberLessSix();
        squareDiagonalArray();
        minMaxElement();
        checkSums();
        shiftElementsArray();

    }

// 1 part of homework

    public static void arrayInvert() {
        int[] invertArr = {1, 0, 0, 1, 1, 1, 0, 0, 0};
        System.out.println("Array before inverting " + Arrays.toString(invertArr));
        for (int i = 0; i < invertArr.length; i++) {
            if (invertArr[i] == 0) {
                invertArr[i] = 1;
            } else {
                invertArr[i] = 0;
            }
        }
        System.out.println("Array after inverting " + Arrays.toString(invertArr));
        System.out.println("                                                    ");
    }

// 2 part of homework

    public static void fillingArray() {

        int[] fillArr = new int[8];
        fillArr[0] = 0;
        System.out.println("Array before filling " + Arrays.toString(fillArr));
        for (int i = 1; i < fillArr.length; i++) {
            fillArr[i] = fillArr[i - 1] + 3;
        }
        System.out.println("Array after filling " + Arrays.toString(fillArr));
        System.out.println("                                                    ");
    }

// 3 part of homework

    public static void arrayWithNumberLessSix() {
        int[] lessSixArr = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        System.out.println("Array before multiplication " + Arrays.toString(lessSixArr));
        for (int i = 0; i < lessSixArr.length; i++) {
            if (lessSixArr[i] < 6) {
                lessSixArr[i] = lessSixArr[i] * 2;
            }
        }
        System.out.println("Array after multiplication " + Arrays.toString(lessSixArr));
        System.out.println("                                                    ");
    }

// 4 part of homework

    public static void squareDiagonalArray() {
        int[][] diagArr = new int[3][3];
        System.out.println("Square empty array " + Arrays.deepToString(diagArr));
        System.out.println("Diagonal filling square array");
        for (int i = 0; i < diagArr.length; i++) {
            diagArr[i][i] = 1;
            System.out.println(Arrays.toString(diagArr[i]));
        }
        System.out.println("                                                    ");
    }

// 5 part of homework

    public static void minMaxElement() {

        int[] minMaxAr = {4, 5, 1, 0, 314, 9, 12};
        System.out.println("Array with various numbers " + Arrays.toString(minMaxAr));
        for (int i = 0; i < minMaxAr.length - 1; i++) {
            if (minMaxAr[i] > minMaxAr[i + 1]) {
                int maxValue = minMaxAr[i];
                int minValue = minMaxAr[i - 1];
                minMaxAr[i] = minMaxAr[i + 1];
                minMaxAr[i + 1] = maxValue;
            } else {
            }
        }
        for (int i = minMaxAr.length - 1; i > 0; i--) {
            if (minMaxAr[i] < minMaxAr[i - 1]) {
                int minValue = minMaxAr[i];
                minMaxAr[i] = minMaxAr[i - 1];
                minMaxAr[i - 1] = minValue;
            } else {
            }
        }
        System.out.println("Array after transformation " + Arrays.toString(minMaxAr));
        System.out.println("Min value of array = " + minMaxAr[0]);
        System.out.println("Max value of array = " + minMaxAr[minMaxAr.length-1]);
        System.out.println("                                                    ");

    }

// 6 part of homework

    public static boolean checkSums () {

        int leftSumm;
        int rightSumm;
        boolean sumsCheck;
        System.out.println("Please enter the lenght of  new array");
        Scanner scanner = new Scanner(System.in);
        int arrLenght = scanner.nextInt();
        System.out.println("Please enter the range of numbers");
        int arrRange = scanner.nextInt();

        int[] sumsArr = new int[arrLenght];

        for (int i = 0; i<sumsArr.length;i++){
            sumsArr[i] = (int) (Math.random()*(arrRange-1));
        }
        System.out.println("New generate random array " + Arrays.toString(sumsArr));
            for (int i = 0; i < sumsArr.length/2-1;i++) {
                int leftSumArr = sumsArr[i] + sumsArr[i+1];
                sumsArr[i+1] = leftSumArr;
            }
            for (int j = sumsArr.length-1; j > sumsArr.length/2; j--) {
                int rightSumArr = sumsArr[j] + sumsArr[j-1];
                sumsArr[j-1] = rightSumArr;
            }
            leftSumm = sumsArr[sumsArr.length/2-1];
            rightSumm = sumsArr[sumsArr.length/2];
//            System.out.println(Arrays.toString(sumsArr));  Для проверки
            System.out.println("Left summ = " + leftSumm);
            System.out.println("Right summ = " + rightSumm);

            if (leftSumm == rightSumm) {
                sumsCheck = true;
            }  else {
                sumsCheck = false;
        }
        System.out.println(sumsCheck);
        System.out.println("                                                    ");
            return(sumsCheck);

}

// 7 part of homework

    public static void shiftElementsArray(){

        System.out.println("Please enter the lenght of new array");
        Scanner scanner = new Scanner(System.in);
        int arrayLenght = scanner.nextInt();
        System.out.println("Please enter the range of numbers");
        int range = scanner.nextInt();
        System.out.println("Please enter shift coefficient");
        int shift = scanner.nextInt();
        int[] shiftArray = new int[arrayLenght];
        for (int i = 1; i<shiftArray.length;i++){
            shiftArray[i] = (int) (Math.random()*(range-1));
        }
        System.out.println(Arrays.toString(shiftArray));

        if (shift>0) {

            for (int j=0; j<shift;j++) {
                int startPosition = shiftArray[0];
                shiftArray[0] = shiftArray[shiftArray.length - 1];
                for (int k = 0; k < shiftArray.length - 1; k++) {
                    int secondPosition = shiftArray[k + 1];
                    shiftArray[k + 1] = startPosition;
                    startPosition = secondPosition;
                }
            }
        } else {
            for (int j = 0; j > shift; j--) {
                int startPosition = shiftArray[shiftArray.length - 1];
                shiftArray[shiftArray.length - 1] = shiftArray[0];
                for (int k = 1; k < shiftArray.length - 1; k++) {
                    shiftArray[k - 1] = shiftArray[k];
                    shiftArray[shiftArray.length-2] = startPosition;
                }
            }
        }
        System.out.println(Arrays.toString(shiftArray));
    }
}





