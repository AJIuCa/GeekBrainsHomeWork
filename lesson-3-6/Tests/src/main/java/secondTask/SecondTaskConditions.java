package secondTask;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SecondTaskConditions {

    private int[] intArray;
    private int constanta1 = 4;
    private int constanta2 = 1;
    protected boolean check = false;

    public SecondTaskConditions(int[] intArray) {
        this.intArray = intArray;
    }

    public SecondTaskConditions() {

    }

    public boolean printIntArray() throws RuntimeException{

        System.out.println("New array  = " + Arrays.toString(intArray));

        List<Integer> newIntArraysList = new ArrayList<>();


        for (int k = 0; k < intArray.length; k++) {
            if (intArray[k] == 1 || intArray[k] == 4) {
                check = true;
            }
        }
        if (check == false) {
            System.out.println(("Our array doesn't have numbers \"4\" and \"1\""));
        }

        System.out.println(check);
        return check;

    }
}