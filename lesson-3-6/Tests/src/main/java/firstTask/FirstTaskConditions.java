package firstTask;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FirstTaskConditions {

    private int[] intArray;
    private int constanta = 4;
    public boolean check;

    public FirstTaskConditions(int[] intArray) {
        this.intArray = intArray;
    }

    public FirstTaskConditions() {

    }

    public int [] printIntArray() throws RuntimeException{

        System.out.println("New array  = " + Arrays.toString(intArray));

        List<Integer> newIntArraysList = new ArrayList<>();

        for (int k : intArray) {
            if (k == constanta) {
                check = true;
            }
        }

        if (check == false) {
            throw new RuntimeException("Our array doesn't have number \"4\"");
        }

                 for(int i = intArray.length - 1; i >=0; i--) {
                        if (intArray[i] == constanta) {
                            for (int j = i + 1; j < intArray.length; j++) {
                                    newIntArraysList.add(intArray[j]);
                                    }
                            break;
                                     }
                                        }
                                        int [] newArray = new int[newIntArraysList.size()];
                                        for (int m = 0; m < newIntArraysList.size(); m++) {
                                            newArray[m] = newIntArraysList.get(m);
                                        }
//                                        System.out.println("Array after transformations = " + newIntArraysList.toString());
                                            System.out.println("Array after transformations = " + Arrays.toString(newArray));

                                            return newArray;
                                    }
                                }
