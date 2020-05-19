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


    public static void main(String[] args) {


        System.out.println("Hello. We have 2 games. \n1 - 'Guess the secret number' \n2 - 'Guess the secret word' " +
                "\nPlease choose the game. Press 1 or 2.");
        Scanner scannerChoose = new Scanner(System.in);
            int choose = scannerChoose.nextInt();
            if (choose == 1) {
                System.out.println("You chose 'Guess the secret number game'. Enjoy. \n      ");
                gameOne();
            } else if (choose == 2) {
                System.out.println("You chose 2 game. Enjoy. \n    ");
                gameTwo();
            } else {
                System.out.println("You should choose 1 or 2 game. Try again.");
            }

    }

    public static void gameOne() {
        Scanner scanner = new Scanner(System.in);
        boolean wannaPlay = true;
        int maxAttempts = 3;
        int minNumber = 0;
        int maxNumber = 9;
        System.out.println("You should guess the secret number from " + minNumber + " to " + maxNumber +
                "\nYou have 3 attempts \n    ");
        while (wannaPlay) {
            int attemp = 1;
            int secretNumber = (int) (Math.random() * (maxNumber - minNumber) + 1);
            while (attemp <= maxAttempts) {
                System.out.println("Attempt " + attemp + ". Choose your number.");
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

    public static void gameTwo() {


        System.out.println("You should guess the word from next list");
        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry",
                "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut",
                "pear", "pepper", "pineapple", "pumpkin", "potato"};
        System.out.println(Arrays.toString(words));
        int randomWord = (int) (Math.random() * words.length + 1);
        String rndWord = words[randomWord];
        System.out.println(rndWord);
        System.out.println("\nPlease, enter your word. Word must contain less than 11 letters");
        Scanner scanner = new Scanner(System.in);
        String yourWord = scanner.nextLine();
        while (yourWord != rndWord) {

            char randomPosition1 = rndWord.charAt(0);
            char randomPosition2 = rndWord.charAt(1);
            char randomPosition3 = rndWord.charAt(2);
            char randomPosition4 = rndWord.charAt(3);
            char randomPosition5 = rndWord.charAt(4);
            char randomPosition6 = rndWord.charAt(5);
            char randomPosition7 = rndWord.charAt(6);
            char randomPosition8= rndWord.charAt(7);
            char randomPosition9 = rndWord.charAt(8);
            char randomPosition10 = rndWord.charAt(9);

            char newPosition1 = yourWord.charAt(0);
            char newPosition2 = yourWord.charAt(1);
            char newPosition3 = yourWord.charAt(2);
            char newPosition4 = yourWord.charAt(3);
            char newPosition5 = yourWord.charAt(4);
            char newPosition6 = yourWord.charAt(5);
            char newPosition7 = yourWord.charAt(6);
            char newPosition8 = yourWord.charAt(7);
            char newPosition9 = yourWord.charAt(8);
            char newPosition10 = yourWord.charAt(9);

//            if (randomPosition1 == newPosition1 | randomPosition2 == newPosition2 | randomPosition3 == newPosition3 |
//                 randomPosition4 == newPosition4 | randomPosition5 == newPosition5 | randomPosition6 = newPosition6 |
//                 randomPosition7 = newPosition7 | randomPosition8 == newPosition8 | randomPosition9 = newPosition9 |
//                 randomPosition10 = newPosition10) {
//                System.out.println("Совпапали символы " + rndWord.charAt(0) + rndWord.charAt(1) + rndWord.charAt(2) +
//                        rndWord.charAt(3) + rndWord.charAt(4) + rndWord.charAt(5) + rndWord.charAt(6) +
//                        rndWord.charAt(7) + rndWord.charAt(8) + rndWord.charAt(9));
//            }
            System.out.println("Try another word");
            String b = scanner.nextLine();
            yourWord = b;
            }
        System.out.println("Congratulations! You win!");

    }
}