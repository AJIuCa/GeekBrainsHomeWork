package ru.geekbrains.lesson4version2;

import java.util.Random;
import java.util.Scanner;

public class TicTacVersion2 {
    public static int sizeField = 5;
    public static final char emptyCell = '.';
    public static final char playerDot = 'X';
    public static final char aiDot = 'O';
    public static char[][] gameField;
    public static Scanner sc = new Scanner(System.in);
    public static Random rand = new Random();

    public static void main(String[] args) {
        playGame();
    }

    public static void playGame() {
        initMap();
        printMap();
        while (true) {
            playerTurn();
            printMap();
            if (conditionsToWin(playerDot)) {
                System.out.println("Player Win. Our Congratulations");
                break;
            }
            if (mapSsFull()) {
                System.out.println("Draw Try again");
                break;
            }
            aiTurn();
            printMap();
            if (conditionsToWin(aiDot)) {
                System.out.println("AI win. Try again");
                break;
            }
            if (mapSsFull()) {
                System.out.println("Draw. Try again");
                break;
            }
        }
    }

    public static void initMap() {
        gameField = new char[sizeField][sizeField];
        for (int i = 0; i < sizeField; i++) {
            for (int j = 0; j < sizeField; j++) {
                gameField[i][j] = emptyCell;
            }
        }
    }

    public static void printMap() {
        for (int i = 0; i < sizeField; i++) {
            for (int j = 0; j < sizeField; j++) {
                System.out.print(gameField[i][j]);
            }
            System.out.println();
        }
    }

    public static void playerTurn() {
        int x, y;
        do {
            System.out.println("Please input X-coordinate");
            x = sc.nextInt() - 1;
            System.out.println("Please input Y-coordinate");
            y = sc.nextInt() - 1;
            if (!isCellValid(x, y)) {
                System.out.println("This cell is used");
            }
        } while (!isCellValid(x, y)); // while(isCellValid(x, y) == false)
        gameField[y][x] = playerDot;
    }

    public static boolean isCellValid(int x, int y) {
        if (x < 0 || x >= sizeField || y < 0 || y >= sizeField) return false;
        if (gameField[y][x] != emptyCell) {
            return false;
        } else {
            return true;
        }
    }

    public static void aiTurn() {
        int x, y;
        do {
            x = rand.nextInt(sizeField);
            y = rand.nextInt(sizeField);
        } while (!isCellValid(x, y));
        System.out.println("AI move to [" + (x + 1) + ";" + (y + 1) + "]");
        gameField[y][x] = aiDot;
    }

    public static boolean conditionsToWin(char symb) {
        for (int i = 0; i < sizeField; i++) {
            if (gameField[1][i] == symb & gameField[2][i] == symb & gameField[3][i] == symb
                    & (gameField[0][i] == symb || gameField[4][i] == symb)) {
                return true;
            }
        }
        for (int i = 0; i < sizeField - 1; i++) {
            if (gameField[i][1] == symb & gameField[i][2] == symb & gameField[i][3] == symb
                    & (gameField[i][0] == symb || gameField[i][4] == symb)) {
                return true;
            }
        }
        if (gameField[0][3] == symb & gameField[1][2] == symb & gameField[2][1] == symb & gameField[3][0] == symb ||
                gameField[0][4] == symb & gameField[1][3] == symb & gameField[2][2] == symb & gameField[3][1] == symb ||
                gameField[1][3] == symb & gameField[2][2] == symb & gameField[3][1] == symb & gameField[4][0] == symb ||
                gameField[1][4] == symb & gameField[2][3] == symb & gameField[3][2] == symb & gameField[4][1] == symb ||
                gameField[0][1] == symb & gameField[1][2] == symb & gameField[2][3] == symb & gameField[3][4] == symb ||
                gameField[1][0] == symb & gameField[2][1] == symb & gameField[3][2] == symb & gameField[4][3] == symb ||
                gameField[0][0] == symb & gameField[1][1] == symb & gameField[2][2] == symb & gameField[3][3] == symb ||
                gameField[1][1] == symb & gameField[2][2] == symb & gameField[3][3] == symb & gameField[4][4] == symb ||) {
            return true;
        }
        return false;
    }

    public static boolean mapSsFull() {
        for (int i = 0; i < sizeField; i++) {
            for (int j = 0; j < sizeField; j++) {
                if (gameField[i][j] == emptyCell) return false;
            }
        }
        return true;
    }


}
