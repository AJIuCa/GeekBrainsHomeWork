package ru.geekbrains.lesson_3_1;

// 1. Написать метод, который меняет два элемента массива местами.(массив может быть любого ссылочного типа);
// 2. Написать метод, который преобразует массив в ArrayList;
// 3. Большая задача:
//  a. Есть классы Fruit -> Apple, Orange;(больше фруктов не надо)
//  b. Класс Box в который можно складывать фрукты, коробки условно сортируются по типу фрукта, поэтому в одну коробку
//     нельзя сложить и яблоки, и апельсины;
//  c. Для хранения фруктов внутри коробки можете использовать ArrayList;
//  d. Сделать метод getWeight() который высчитывает вес коробки, зная количество фруктов и вес одного фрукта
//    (вес яблока - 1.0f, апельсина - 1.5f, не важно в каких это единицах);
//  e. Внутри класса коробка сделать метод compare, который позволяет сравнить текущую коробку с той, которую подадут
//     в compare в качестве параметра, true - если их веса равны, false в противном случае(коробки с яблоками мы можем
//     сравнивать с коробками с апельсинами);
//  f. Написать метод, который позволяет пересыпать фрукты из текущей коробки в другую коробку(помним про сортировку
//     фруктов, нельзя яблоки высыпать в коробку с апельсинами), соответственно в текущей коробке фруктов не остается,
//     а в другую перекидываются объекты, которые были в этой коробке;
//  g. Не забываем про метод добавления фрукта в коробку.


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Main {

    public static void main(String[] args) {

        startApp();

    }

    public static void startApp () {

        arrayTransformation();

    }

    public static void arrayTransformation() {

        Integer [] simpleArray = new Integer[5];
        simpleArray[0] = 5;
        simpleArray[1] = 6;
        simpleArray[2] = 1;
        simpleArray[3] = 4;
        simpleArray[4] = 99;

            System.out.println("Array before shuffle = " + Arrays.toString(simpleArray));
            shuffle(2,4, simpleArray);
            System.out.println("Array after shuffle = " + Arrays.toString(simpleArray));

            ArrayList<Integer> newArrayList = (ArrayList<Integer>) transformToArrayList(simpleArray);
            System.out.println("Array after transformations into ArrayList = " + newArrayList);
    }


    public static <T> List<T> transformToArrayList (T [] array){

        List <T> transformation = new ArrayList(Arrays.asList(array));
        return transformation;
    }



    public static void shuffle (int firstPosition, int secondPosition, Object []  array) {

        Object anyObject = array [firstPosition];
        array[firstPosition] = array [secondPosition];
        array[secondPosition] = anyObject;





    }

}
