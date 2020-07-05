package ru.geekbrains.lesson_2_7;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        startApp();

    }

    public static void startApp() {

        TwoDirectionList List2 = new TwoDirectionList();

        List2.add("val1");
        List2.add("val2");
        List2.add("val3");
        List2.add("val4");


        TwoDirectionList.TwoDirectionNode current2 = (TwoDirectionList.TwoDirectionNode) List2.getFirst();

        System.out.println(current2.getVal());
        System.out.println(current2.getNextLink().getVal());
        System.out.println(current2.getNextLink().getNextLink().getVal());
        System.out.println(current2.getNextLink().getNextLink().getNextLink().getVal());

        System.out.println("Size: " + List2.size());


    }
}
