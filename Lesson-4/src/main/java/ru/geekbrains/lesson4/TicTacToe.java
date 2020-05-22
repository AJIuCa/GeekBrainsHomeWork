package ru.geekbrains.lesson4;
import java.util.Random;
import java.util.Scanner;


public class TicTacToe {
    public static final int sizeField = 3;
    public static Random random = new Random();
    public static Scanner scanner = new Scanner(System.in);
    public static final char playerSign = 'X';
    public static final char aiSign = 'O';

    public static void main(String[] args) {
        playGame();
    }

    public static void playGame() {
        String currentPlayerName = "Player";
        char currentPlayerSign = playerSign;
        char[][] field = emptyGameField();
        boolean win;
        paintGameField(field);

        do {
            playerTurn(field);
            aiTurn(field);
            win = checkPropertiesToWin(field, currentPlayerSign);
            if (!win) {
                currentPlayerSign = currentPlayerSign == 'X' ? 'O' : 'X';
                currentPlayerName = currentPlayerSign == 'X' ? "Player" : "AI";
            }

        } while (!win);
        System.out.println("The "+currentPlayerName+" are winner! Our congratulations " + currentPlayerName);
        if (!draw(field)){
            System.out.println("Draw");
        }
    }

    static char [][] emptyGameField () {
        char empty = '.';
        char[][] field = new char[sizeField][sizeField];
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field.length; j++) {
                field[i][j] = empty;
            }
        }
        return field;
    }

    static void paintGameField(char[][] field) {
        for (int i = 0; i < sizeField; i++) {
            for (int j = 0; j < sizeField; j++) {
                System.out.print(field[i][j]);
            }
            System.out.println();
        }
    }
    public static void playerTurn (char[][] field){
        int x;
        int y;
        System.out.println("Player turn");
        do {
            boolean correct;
            do {
                System.out.println("Input X-coordinates from 1 to " + sizeField);
                x = scanner.nextInt() - 1;
                System.out.println("Input Y-coordinates from 1 to " + sizeField);
                y = scanner.nextInt() - 1;
                correct = checkPlayersTurn(x,y);
                if (!checkPlayersTurn(x, y)) {
                    System.out.println("\bError. Please input coordinates from 1 to " + sizeField);
                }
            }while(!correct);
            if ( field[y][x] !='.') {
                System.out.println("\bThis cell ("+(x+1)+";"+(y+1)+") is occupied. Try again");
            }
        } while (field[y][x] !='.');
        field[y][x] = playerSign;
        paintGameField(field);
    }
    public static boolean checkPlayersTurn (int x, int y) {
        if ((x<0 || x>=sizeField) || (y<0 || y>=sizeField)) {
            return false;
        }
        return true;
    }
    public static void aiTurn (char[][] field) {
        int x;
        int y;
        System.out.println("AI turn");
        do {
            x = random.nextInt(3);
            y = random.nextInt(3);
        } while (field[y][x] != '.');
        field[y][x] = aiSign;
        paintGameField(field);
    }
    static  boolean horizontalWinConditions (char[][] field, char playerSign){
        for ( int i = 0; i<sizeField;i++) {
            if (field [i][0] == playerSign & field [i][1] == playerSign & field [i][2] == playerSign) {
                return true ;
            }
        }
        return false;
    }
    static  boolean VerticalwinConditions (char[][] field, char playerSign){
        for ( int i = 0; i<sizeField;i++) {
            if (field [0][i] == playerSign & field [1][i] == playerSign & field [2][i] == playerSign) {
                return true ;
            }
        }
        return false;
    }
    static  boolean diagonalWinConditions (char[][] field, char playerSign){
        if (field[0][0] == playerSign & field[1][1] == playerSign & field[2][2] == playerSign ||
                field[0][2] == playerSign & field[1][1] == playerSign & field[2][0] == playerSign ) {
            return true;
        } else {
            return  false;
        }
    }

    public static boolean checkPropertiesToWin (char[][] field, char playerSign){
        if (VerticalwinConditions(field, playerSign)){
            return true;
        }
        if (horizontalWinConditions(field, playerSign)) {
            return true;
        }
        if (diagonalWinConditions(field, playerSign)) {
            return true;
        }
        return false;
    }
    public static boolean draw (char[][]field) {
        for (int i = 0; i < sizeField; i++) {
            for (int j = 0; j < sizeField; j++) {
                if (field[i][j] == '.')
                    return false;
            }
        }
        return true;
    }
}
