package secondTask;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SecondTaskConditionsTest {

    SecondTaskConditions secondTaskConditions1;
    SecondTaskConditions secondTaskConditions2;
    SecondTaskConditions secondTaskConditions3;
    SecondTaskConditions secondTaskConditions4;

    private static int[] coreIntArray = {1, 4, 5, 1 , 4, 6, 9};
    private static int[] coreIntArrayWith1 = {1, 1, 1, 1 , 1, 1, 1};
    private static int[] coreIntArrayWith4 = {4, 4, 4, 4, 4, 4, 4};

    private static int[] coreIntArrayExcludeNumber4AND1 = {2, 3, 5, 7 , 3, 6, 8};



    public SecondTaskConditionsTest() {
    }

    @BeforeEach

    public void init () {

        Assertions.assertNotNull(coreIntArray);
        Assertions.assertNotNull(coreIntArrayWith1);
        Assertions.assertNotNull(coreIntArrayWith4);
        Assertions.assertNotNull(coreIntArrayExcludeNumber4AND1);
    }

    @Test
    public void printIntArrayTest () {

        secondTaskConditions1 = new SecondTaskConditions(coreIntArray);
        secondTaskConditions2 = new SecondTaskConditions(coreIntArrayWith1);
        secondTaskConditions3 = new SecondTaskConditions(coreIntArrayWith4);
        secondTaskConditions4 = new SecondTaskConditions(coreIntArrayExcludeNumber4AND1);

        Assertions.assertTrue(secondTaskConditions1.printIntArray());
        Assertions.assertTrue(secondTaskConditions2.printIntArray());
        Assertions.assertTrue(secondTaskConditions3.printIntArray());
        Assertions.assertFalse(secondTaskConditions4.printIntArray());

//        Assertions.assertArrayEquals(arrayForCheck1, secondTaskConditions.printIntArray());
//        Assertions.assertNotEquals(arrayForCheck2, secondTaskConditions.printIntArray());
//        Assertions.assertNotNull(secondTaskConditions);
//        Assertions.assertThrows(RuntimeException.class, ()-> {
//            secondTaskConditions2.printIntArray();
//        });

    }

}