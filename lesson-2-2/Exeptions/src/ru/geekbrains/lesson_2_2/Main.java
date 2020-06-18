package ru.geekbrains.lesson_2_2;


// 1. Напишите метод, на вход которого подаётся двумерный строковый массив размером 4х4, при подаче массива другого
//        размера необходимо бросить исключение MyArraySizeException.
// 2. Далее метод должен пройтись по всем элементам массива, преобразовать в int, и просуммировать. Если в каком-то
//        элементе массива преобразование не удалось (например, в ячейке лежит символ или текст вместо числа), должно
//        быть брошено исключение MyArrayDataException, с детализацией в какой именно ячейке лежат неверные данные.
// 3. В методе main() вызвать полученный метод, обработать возможные исключения MySizeArrayException и
//        MyArrayDataException, и вывести результат расчета.

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static int maxX = 4;
    static int maxY = 4;

    public static void main(String[] args) throws MyArraySizeException, MyArrayDataException {

        startApp();
    }

    public static void startApp() throws MyArraySizeException, MyArrayDataException {

        try {
            squareArray();
        } catch (MyArraySizeException e) {
            System.out.println("Array must be [4][4]. Try again.");
            squareArray();
        }
        try {
            randomArray();
        } catch (MyArrayDataException e) {
            System.out.println("Only number symbol can be converted to INT.");
            System.out.println("Switch to random array without letters symbols.\n");
            randomArrayWithoutLetters();
        }
    }

    public static void squareArray() throws MyArraySizeException {

        System.out.println("Enter array size.");
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        if (x != 4 & y != 4) {
            throw new MyArraySizeException("You should input 4x4 array");
        } else {
            String[][] squareArray = new String[x][y];
            for (int i = 0; i < squareArray.length; i++) {
                for (int j = 0; j < squareArray[i].length; j++) {
                    String k = Integer.toString((int) (Math.random() * 10));
                    squareArray[i][j] = k;
                    System.out.print(squareArray[i][j] + " ");
                }
                System.out.println();
            }

        }
        System.out.println("\b");
    }

    public static void randomArray() throws MyArrayDataException {

        int sum = 0;
        int x = maxX;
        int y = maxY;
        String[] symbolList = new String[]{"i", "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "j", "k", "f"};
        System.out.println("Random STRING array");
        String[][] squareStringArray = new String[x][y];
        for (int i = 0; i < squareStringArray.length; i++) {
            for (int j = 0; j < squareStringArray[i].length; j++) {
                squareStringArray[i][j] = symbolList[(int) (Math.random() * (symbolList.length - 1))];
                System.out.print(squareStringArray[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("Convert to INT.");
        for (int i = 0; i < squareStringArray.length; i++) {
            for (int j = 0; j < squareStringArray[i].length; j++) {
                if (squareStringArray[i][j] == "i" || squareStringArray[i][j] == "j" || squareStringArray[i][j] == "k"
                        || squareStringArray[i][j] == "f") {
                    System.out.println("Error in [" + (i + 1) + "][" + (j + 1) + "] cell.");
                    throw new MyArrayDataException("Only number symbol can be converted to INT.");
                }
            }
        }
        int[][] squareIntArray = new int[x][y];
        for (int a = 0; a < squareIntArray.length; a++) {
            for (int b = 0; b < squareIntArray[a].length; b++) {
                squareIntArray[a][b] = Integer.parseInt(squareStringArray[a][b]);
                System.out.print(squareIntArray[a][b] + " ");
            }
            System.out.println();
        }
        for (int i = 0; i < squareIntArray.length; i++) {
            for (int j = 0; j < squareIntArray.length; j++) {
                sum = sum + squareIntArray[i][j];
            }
        }
        System.out.println("Sum of all numbers from randomIntArrayWithoutLetters = " + sum);
    }

    public static void randomArrayWithoutLetters() {

        int sum = 0;
        int x = maxX;
        int y = maxY;
        String[] symbolList = new String[]{"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
        String[][] randomArrayWithoutLetters = new String[x][y];
        for (int i = 0; i < randomArrayWithoutLetters.length; i++) {
            for (int j = 0; j < randomArrayWithoutLetters[i].length; j++) {
                randomArrayWithoutLetters[i][j] = symbolList[(int) (Math.random() * (symbolList.length - 1))];
            }
        }
        int[][] randomIntArrayWithoutLetters = new int[x][y];
        for (int a = 0; a < randomIntArrayWithoutLetters.length; a++) {
            for (int b = 0; b < randomIntArrayWithoutLetters[a].length; b++) {
                randomIntArrayWithoutLetters[a][b] = Integer.parseInt(randomArrayWithoutLetters[a][b]);
                System.out.print(randomIntArrayWithoutLetters[a][b] + " ");
            }
            System.out.println();
        }
        for (int i = 0; i < randomIntArrayWithoutLetters.length; i++) {
            for (int j = 0; j < randomIntArrayWithoutLetters.length; j++) {
                sum = sum + randomIntArrayWithoutLetters[i][j];
            }
        }
        System.out.println("Sum of all numbers from randomIntArrayWithoutLetters = " + sum);
    }
}


