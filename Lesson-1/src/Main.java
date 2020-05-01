import java.util.Scanner;
import java.util.stream.IntStream;


// ДОМАЩНЕЕ ЗАДАНИЕ 1
//  1. Создать пустой проект в IntelliJ IDEA и прописать метод main();
//  2. Создать переменные всех пройденных типов данных, и инициализировать их значения;
//  3. Написать метод вычисляющий выражение a * (b + (c / d)) и возвращающий результат,
//      где a, b, c, d – входные параметры этого метода;
//  4. Написать метод, принимающий на вход два числа, и проверяющий что их сумма лежит в пределах
//      от 10 до 20(включительно), если да – вернуть true, в противном случае – false;
//  5. Написать метод, которому в качестве параметра передается целое число, метод должен напечатать
//      в консоль положительное ли число передали, или отрицательное; Замечание: ноль считаем положительным числом.
//  6. Написать метод, которому в качестве параметра передается целое число, метод должен вернуть true,
//      если число отрицательное;
//  7. Написать метод, которому в качестве параметра передается строка, обозначающая имя, метод должен вывести
//      в консоль сообщение «Привет, указанное_имя!»;
//  8. * Написать метод, который определяет является ли год високосным, и выводит сообщение в консоль.
//      Каждый 4-й год является високосным, кроме каждого 100-го, при этом каждый 400-й – високосный.

public class Main {

    public static void main(String[] args) {
        // 1 часть задания

        System.out.println("1 PART OF HOME WORK");
        System.out.println("Empty project created");

        // 2 часть задания

        System.out.println("2 PART OF HOME WORK");

        byte bt = 0;
        short shrt = 1;
        int i = 2;
        long lg = 3;
        float fl = (float) shrt;
        double db = 5.1;
        char cr = '7';
        boolean boo = true;

        System.out.println("byte = " + bt + "; short = " + shrt + "; int = " + i + "; long = " + lg + "; " +
                "float = " + fl + "; double = " + db + "; char = " + cr + "; boolean  = " + boo);

        // вызов метода из 3 части задания
        part3();
        //  вызов метода из 4 части задания
        part4();
        //  вызов метода из 5 части задания
        part5();
        //  вызов метода из 6 части задания
        part6();
        //  вызов метода из 7 части задания
        part7();
        // вызов метода из 8 части задания
        part8();
    }

    // 3 часть задания

    public static void part3() {

        System.out.println("3 PART OF HOME WORK");

        int a = 1;
        int b = 2;
        int c = 49;
        int d = 7;
        int ZZ = a * (b + (c / d));

        System.out.println("a*(b+(c/d)) = " + ZZ);

//        return part3();
    }

    // 4 часть задания

    public  static void part4() {

        System.out.println("4 PART OF HOME WORK");

        Scanner sc1 = new Scanner(System.in);

        System.out.println("Enter first number");
        int firstNumber = sc1.nextInt();

        System.out.println("Enter second number");
        int secondNumber = sc1.nextInt();

        if ((firstNumber + secondNumber) > 10 && (firstNumber + secondNumber) <= 20) {
            System.out.println("True");
        } else {
            System.out.println("DeathToTheFalseEmperor");
        }
//        return part4();
    }

    // 5 часть задания

    public static void part5() {

        System.out.println("5 PART OF HOME WORK");

        System.out.println("Enter integer number");

        Scanner sc2 = new Scanner(System.in);
        int intNumber = sc2.nextInt();

        if (intNumber >= 0) {
            System.out.println("This number positive");
        } else {
            System.out.println("This number negative");
        }
    }

    // 6 часть

    public static void part6() {

        System.out.println("6 PART OF HOME WORK");

        System.out.println("Enter new integer number");
        Scanner sc3 = new Scanner(System.in);
        int newIntNumber = sc3.nextInt();
        while (newIntNumber >= 0) {
            System.out.println("This number so big");
            newIntNumber = sc3.nextInt();
        }
        System.out.println("TUE!!");
    }

    // 7 часть

    public static void part7() {

        System.out.println("7 PART OF HOME WORK");

        System.out.println("Whats your name?");
        Scanner sc4 = new Scanner(System.in);
        String bb = sc4.next();
//  String naMe = sc.nextLine(); - Не понял почему такая команда не обрабатывается, а сразу идут команда вывода текста.
//  Пробовал отдельно запустить этот кусок кода (задание7) отдельно от других частей, тогда в консоли можно ввести текст.
        System.out.println("Salute " + bb + "!!!");

    }

    // 8 часть

    public static void part8() {

        System.out.println("8 PART OF HOME WORK");

        int firstYear = 0;
        int step = 4;
        int[] leapYear = new int [999999999];
        leapYear[0]=firstYear;

        for (int x=1; x <= leapYear.length-1; x++){
            leapYear[x] = leapYear[x-1] + step;
        }

        System.out.println("Choose your year");
        Scanner sc5= new Scanner(System.in);
        int year  = sc5.nextInt();
        boolean result = IntStream.of(leapYear).anyMatch(v -> v == year);
        if (result) {
            System.out.println("This leap year");
        } else {
            System.out.println("This not leap year");
        }

    }
}