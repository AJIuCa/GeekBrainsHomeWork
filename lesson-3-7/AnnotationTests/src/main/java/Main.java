import java.lang.reflect.InvocationTargetException;

public class Main {

    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {

        startApp();

    }

    public static void startApp () throws InvocationTargetException, IllegalAccessException {

//        Test.methodsList();
        TestClass.startTest();

    }

}
