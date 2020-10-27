import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
public class Main {

    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException, InstantiationException {

        startApp();

    }

    public static void startApp () throws InvocationTargetException, IllegalAccessException, InstantiationException {
        Test test = new Test();
        test.startTest(Pupil.class);

    }


}
