package ru.geekbrains.lesson_2_3;


//  1. Создать массив с набором слов (10-20 слов, должны встречаться повторяющиеся). Найти и вывести список
//    уникальных слов, из которых состоит массив (дубликаты не считаем). Посчитать сколько раз встречается
//    каждое слово.
//  2. Написать простой класс ТелефонныйСправочник, который хранит в себе список фамилий и телефонных номеров.
//    В этот телефонный справочник с помощью метода add() можно добавлять записи. С помощью метода get()
//    искать номер телефона по фамилии. Следует учесть, что под одной фамилией может быть несколько
//    телефонов (в случае однофамильцев), тогда при запросе такой фамилии должны выводиться все телефоны.


import java.security.Key;
import java.util.*;

public class Main {

    public static void main(String[] args) {
//        repeatedWords();
        phoneBooks();
    }


    public static void repeatedWords() {

        ArrayList<String> listArray = new ArrayList<>();
        listArray.add("dog");
        listArray.add("nurgle");
        listArray.add("music");
        listArray.add("music");
        listArray.add("cat");
        listArray.add("cry");
        listArray.add("java");
        listArray.add("sabaton");
        listArray.add("zerg");
        listArray.add("zerg");
        listArray.add("slayer");
        listArray.add("snake");
        listArray.add("deathguard");
        listArray.add("KKnD");
//        System.out.println(listArray);

        Set <String> hashSetArray = new HashSet<>(listArray);
        System.out.println(hashSetArray);


        HashMap<String, Integer> repeatedWords = new HashMap();
        for (String word : listArray) {
            if (!repeatedWords.containsKey(word)) {
                repeatedWords.put(word, 0);
            }
            repeatedWords.put(word, repeatedWords.get(word) + 1);
            System.out.println(word + " = " + repeatedWords.get(word));
        }
    }
    public static void phoneBooks () {
//        PhoneBook contact1 = new PhoneBook("Petrov",222);
//        PhoneBook contact2 = new PhoneBook("Kozlov",1246977);
//        PhoneBook contact3 = new PhoneBook("Yagodka",7789964);

        Surname surname1 = new Surname("Petro");
        Surname surname2 = new Surname("Sergo");
        Surname surname3 = new Surname("Yagodka");
        Surname surname4 = new Surname("Super");

        PhoneNumber phoneNumber1 = new PhoneNumber(23);
        PhoneNumber phoneNumber2 = new PhoneNumber(7477);
        PhoneNumber phoneNumber3 = new PhoneNumber(123);
        PhoneNumber phoneNumber4 = new PhoneNumber(3333);

        HashMap<Object, Object> phoneBook = new HashMap<>();
        phoneBook.put(surname1.getSurname(), phoneNumber1.getPhonenumber());
        phoneBook.put(surname2.getSurname(), phoneNumber2.getPhonenumber());
        phoneBook.put(surname3.getSurname(), phoneNumber3.getPhonenumber());
        phoneBook.put(surname4.getSurname(), phoneNumber4.getPhonenumber());

        System.out.println(phoneBook.entrySet());
        for (Object val : phoneBook.values()) {
            System.out.println(val);
        }
    }
}


