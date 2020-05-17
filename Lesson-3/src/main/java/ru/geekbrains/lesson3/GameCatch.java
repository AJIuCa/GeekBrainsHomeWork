package ru.geekbrains.lesson3;

import java.util.Arrays;
import java.util.Scanner;

//1. Написать программу, которая загадывает случайное число от 0 до 9, и пользователю дается 3 попытки угадать это
//  число. При каждой попытке компьютер должен сообщить больше ли указанное пользователем число чем загаданное, или
//  меньше. После победы или проигрыша выводится запрос – «Повторить игру еще раз? 1 – да / 0 – нет»
//  (1 – повторить, 0 – нет).
//2 * Создать массив из слов String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli",
//  "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea",
//  "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};
//      При запуске программы компьютер загадывает слово, запрашивает ответ у пользователя,
//      сравнивает его с загаданным словом и сообщает правильно ли ответил пользователь. Если слово не угадано,
//      компьютер показывает буквы которые стоят на своих местах.
//      apple – загаданное
//      apricot - ответ игрока
//      ap############# (15 символов, чтобы пользователь не мог узнать длину слова)
//      Для сравнения двух слов посимвольно, можно пользоваться:
//      String str = "apple";
//      str.charAt(0); - метод, вернет char, который стоит в слове str на первой позиции
//      Играем до тех пор, пока игрок не отгадает слово
//      Используем только маленькие буквы

public class GameCatch {



    public static void main (String[] args) {

        System.out.println("Hello. We have 2 games. \n1 - 'Guess the secret number' \n2 - 'Guess the secret word' " +
                "\nPlease choose the game. Press 1 or 2.");
        Scanner scannerChoose = new Scanner(System.in);
        int choose = scannerChoose.nextInt();
        if (choose == 1) {
            System.out.println("You choose 'Guess the secret number game'. Enjoy. \n      ");
            gameOne();
        } else if (choose == 2) {
            System.out.println("You choose 2 game. Enjoy. \n    ");
            ganeTwo();
        } else {
            System.out.println("You should choose 1 or 2 game. Try again.");
        }
    }

    public static void gameOne () {
        Scanner scanner = new Scanner(System.in);
        boolean wannaPlay = true;
        int maxAttempts = 3;
        int minNumber = 0;
        int maxNumber = 9;
        System.out.println("You should guess the secret number from " + minNumber + " to " + maxNumber +
                "\nYou have 3 attempts \n    ");
        while (wannaPlay){
            int attemp = 1;
            int secretNumber = (int) (Math.random() * (maxNumber - minNumber) + 1);
            while (attemp <= maxAttempts) {
                System.out.println("Try " + attemp + ". Choose your number.");
                int inputNumber = scanner.nextInt();
                if (inputNumber == secretNumber) {
                    System.out.println("Congratulation! You guessed!");
                    break;
                } else if (inputNumber > secretNumber) {
                    System.out.println("Secret Number is less");
                    attemp++;
                    if (attemp == maxAttempts + 1) {
                        System.out.println("Game Over");
                    }
                } else if (inputNumber < secretNumber) {
                    System.out.println("Secret Number is bigger");
                    attemp++;
                    if (attemp == maxAttempts + 1) {
                        System.out.println("Game Over");
                    }
                }
            }
            System.out.println("Do you want to play again?");
            boolean choose = scanner.nextBoolean();
            wannaPlay = choose;
        }
    }

//2 * Создать массив из слов String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli",
//  "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea",
//  "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};
//      При запуске программы компьютер загадывает слово, запрашивает ответ у пользователя,
//      сравнивает его с загаданным словом и сообщает правильно ли ответил пользователь. Если слово не угадано,
//      компьютер показывает буквы которые стоят на своих местах.
//      apple – загаданное
//      apricot - ответ игрока
//      ap############# (15 символов, чтобы пользователь не мог узнать длину слова)
//      Для сравнения двух слов посимвольно, можно пользоваться:
//      String str = "apple";
//      str.charAt(0); - метод, вернет char, который стоит в слове str на первой позиции
//      Играем до тех пор, пока игрок не отгадает слово
//      Используем только маленькие буквы

    public static void ganeTwo () {
        System.out.println("You should guess the word from next list");
        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry",
                "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut",
                "pear", "pepper", "pineapple", "pumpkin", "potato"};
        System.out.println(Arrays.toString(words));
        int randomWord = (int) Math.random()*words.length+1;
        System.out.println(words[randomWord]);
        Scanner scanner = new Scanner(System.in);
        String yourWord = scanner.next();
    }

}