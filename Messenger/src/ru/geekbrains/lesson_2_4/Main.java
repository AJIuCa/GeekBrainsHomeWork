package ru.geekbrains.lesson_2_4;

//  1. Создать окно для клиентской части чата: большое текстовое поле для отображения переписки в центре окна.
//  Однострочное текстовое поле для ввода сообщений и кнопка для отсылки сообщений на нижней панели. Сообщение
//  должно отсылаться либо по нажатию кнопки на форме, либо по нажатию кнопки Enter. При «отсылке» сообщение
//  перекидывается из нижнего поля в центральное.

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