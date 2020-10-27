package secondTask;

import java.util.Scanner;

public class SecondTaskStart {


    public SecondTaskStart()  {

    }

    public static void startSecondTask () {

        System.out.println("\nSECOND TASK START\n-------------------------------------");
        SecondTaskConditions secondTask = new SecondTaskConditions(createArray());
        secondTask.printIntArray();

    }

    public static int [] createArray () {

        int [] array;

        System.out.println("Choose array length");
        Scanner scanner = new Scanner(System.in);
        int length = scanner.nextInt();
        if (length <= 0) {
            while (length <= 0) {
                System.out.println("Length incorrect. Please choose length  > 0");
                length = scanner.nextInt();
            }
        }
        array = new int[length];
        System.out.println("Please fill our array");
        for (int i=0; i < array.length; i++) {
            array[i] = scanner.nextInt();
        }

        return array;
    }

}
