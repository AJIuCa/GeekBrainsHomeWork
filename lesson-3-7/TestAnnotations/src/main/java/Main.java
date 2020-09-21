import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
public class Main {

    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException, ClassNotFoundException {

        startApp();

    }

    public static void startApp () throws InvocationTargetException, IllegalAccessException, ClassNotFoundException {

        Test.methodsList();
        Test.startTest();

    }


}
