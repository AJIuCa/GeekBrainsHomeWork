package ru.geekbrains.lesson_2_4;


public class Main {

    public static void main (String [] args) {
        startApp();
    }

    public static void startApp () {
        messengerApp();
    }

    public static void messengerApp () {

        MessangerTemplateWindow app = new MessangerTemplateWindow("WebMessenger");

    }
}