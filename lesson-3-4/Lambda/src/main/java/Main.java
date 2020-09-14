//  1. Напишите метод, который возвращает индекс первого вхождения данного целого числа в списке.
//      Предположим, что индекс первого элемента в списке равен нулю.
//      Если числа не существует в списке, верните -1.
//      public int search(Integer n, Integer[] list)
//
//  2. Напишите метод, переворачивающий строку.
//      Например, «java interview» превращается в «weivretni avaj».
//      public String reverse(String s)
//
//  3. Напишите метод, который возвращает наибольшее целое число в списке.
//      public Integer maximum(Integer[] list)
//
//  4. Напишите метод, который возвращает среднее значение из списка целых чисел.
//      public Double average(List<Integer> list)
//
//  5. Имея список строк, напишите метод, который возвращает список всех строк, которые начинаются с буквы «а» (нижний регистр) и имеют ровно 3 буквы.
//      public List<String> search(List<String> list)
//
//Все должно быть реализовано с помощью лямбда выражений


import java.util.ArrayList;
import java.util.List;

public class Main {

    static int b = 0;
    static int secretNumber = 355;
    static String phrase = "Adeptus mechanicus";
    static ArrayList<Integer> arrList;
    static List<String> stringList;


    public static void main(String[] args) {

        startApp();

    }

    public static void startApp() {
        System.out.println("<--------------------GAME START------------------------------>\n");

        System.out.println("<--------------------FirstTask------------------------------->\n");
        firstTask();
        System.out.print("\n");
        System.out.println("<--------------------SecondTask------------------------------>\n");
        secontTask();
        System.out.print("\n");
        System.out.println("<--------------------ThirdTask-------------------------------->\n");
        thirdTask();
        System.out.print("\n");
        System.out.println("<--------------------FourthTask------------------------------->\n");
        fourthTask();
        System.out.print("\n");
        System.out.println("<---------------------FifthTask------------------------------->\n");
        FifthTask();
        System.out.print("\n");
        System.out.println("<---------------------GAME OVER------------------------------->\n");

    }

    public static void firstTask() {

        int[] randomNumber = {0, 35, 7, 36, 796, 0};

        LambdaSearch lambda;

        lambda = (x, y) -> {
            for (int i : y) {
                if (x == i) {
                    System.out.println("This number equals = " + i);
                    b = i;
                    break;
                }
            }
            if (b == 0) {
                System.out.println("This array don't have your Number");
            }
            return x = -1;
        };

        int search = lambda.search(secretNumber, randomNumber);
    }

    public static void secontTask() {

        LambdaReverse lamdaRev;

        lamdaRev = x -> {

            //  Перевернуть можно так же используя stringBuffer
            //
            //String bufferString = new StringBuffer(phrase).reverse().toString();
            // x = bufferString;
            // System.out.println(x);

            System.out.println(x);

            char[] toCharArr = x.toCharArray();
            String bufferString = "";

            for (int i = toCharArr.length - 1; i >= 0; i--) {

                bufferString = bufferString + toCharArr[i];

            }

            x = bufferString;
            System.out.println(x);
            return x;
        };

        String reverse = lamdaRev.reverse(phrase);

    }

    public static void thirdTask() {

        arrList = new ArrayList<>();
        arrList.add(0);
        arrList.add(9);
        arrList.add(56);
        arrList.add(15);
        arrList.add(3);
        arrList.add(1);

        System.out.println(arrList.toString());

        LambdaMaxNumber maxNmb;

        maxNmb = x -> {


            for (int i = 0; i < x.size() - 1; i++) {

                for (int j = i + 1; j < x.size(); j++) {

                    if (x.get(i) > x.get(j)) {

                        Integer a = x.get(i);
                        Integer b = x.get(j);
                        x.set(i, b);
                        x.set(j, a);
                    }
                }
            }
            System.out.println(x.toString());
            System.out.println(x.get(x.size() - 1));
            return null;
        };

        Integer maxNMB = maxNmb.maxNumber(arrList);


    }

    public static void fourthTask() {

        System.out.println(arrList.toString());

        LambdaMeanValue meanValue;

        meanValue = x -> {
            Integer j = 0;
            for (int i = 0; i < x.size(); i++) {

                Integer sum = x.get(i) + j;
                j = sum;
            }
            System.out.println("Mean Value = " + j / x.size());
            return null;
        };

        Integer meanNumber = meanValue.meanValue(arrList);

    }

    public static void FifthTask() {

        stringList = new ArrayList<>();
        stringList.add("car");
        stringList.add("Apple");
        stringList.add("arr");
        stringList.add("South");
        stringList.add("necron");
        stringList.add("ape");
        stringList.add("Ave");

        List <String> wordsWithLengths3 = new ArrayList<>();

        LambdaStringSearching searchStringLMBD;

        searchStringLMBD = x -> {
            System.out.println(stringList.toString());
            for (String i : x) {

                if (i.length() == 3 && i.indexOf("a") == 0) {
                    wordsWithLengths3.add(i);

                }
            }
                System.out.println(wordsWithLengths3.toString());
                return null;
        };

        String srch = searchStringLMBD.stringSearch(stringList);

    }
}
