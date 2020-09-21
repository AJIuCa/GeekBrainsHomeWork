package firstTask;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

//import java.util.logging.LogManager;
//import java.util.logging.Logger;

public class FirstTaskConditionsTest {

    public static final Logger LOGGER = LogManager.getLogger(FirstTaskConditionsTest.class);

    FirstTaskConditions firstTaskConditions;
    FirstTaskConditions firstTaskConditions2;

    private static int[] coreIntArray = {1, 3, 5, 7, 4, 6, 8};
    private static int[] coreIntArrayExcludeNumber4 = {1, 3, 5, 7, 3, 6, 8};
    private static int[] arrayForCheck1 = {6, 8};
//    private static int[] arrayForCheck1 = null;
    private static int[] arrayForCheck2 = {6, 9};


    public FirstTaskConditionsTest() {
    }

    @BeforeEach

    public void init() {

        Assertions.assertNotNull(coreIntArray);
        Assertions.assertNotNull(coreIntArrayExcludeNumber4);
        Assertions.assertNotNull(arrayForCheck1);
        Assertions.assertNotNull(arrayForCheck2);
    }

    @Test
    public void printIntArrayTest() {


            LOGGER.log(Level.INFO, "Test");

            firstTaskConditions = new FirstTaskConditions(coreIntArray);
            firstTaskConditions2 = new FirstTaskConditions(coreIntArrayExcludeNumber4);
            Assertions.assertArrayEquals(arrayForCheck1, firstTaskConditions.printIntArray());
            Assertions.assertNotEquals(arrayForCheck2, firstTaskConditions.printIntArray());
            Assertions.assertNotNull(firstTaskConditions);
            Assertions.assertThrows(RuntimeException.class, () -> {
                firstTaskConditions2.printIntArray();
            });

    }
}
