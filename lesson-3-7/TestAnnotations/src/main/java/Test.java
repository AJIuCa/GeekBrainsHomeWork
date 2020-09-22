import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Test {

    static Method[] pupilMethods = Pupil.class.getDeclaredMethods();
    static Field[] pupilField = Pupil.class.getDeclaredFields();

    public static void methodsList() {

        System.out.println("methods list");


        for (Method i : pupilMethods) {
            System.out.println(i.getName());
        }
        System.out.println("");
    }


    public static void startTest() throws InvocationTargetException, IllegalAccessException {

        Pupil pupil1 = new Pupil();

        int counter1 = 0;
        int counter2 = 0;


        for (Method z : pupilMethods) {

            if (z.getAnnotation(BeforeSuite.class) != null) {
                if (counter1 > 0) throw new RuntimeException();
                counter1++;
                z.invoke(pupil1);
            }
        }

        for (Method z : pupilMethods) {
            if (z.getAnnotation(TestMethods.class) != null) {
                z.invoke(pupil1);
            }
        }


        for (Method z : pupilMethods) {

            if (z.getAnnotation(AfterSuite.class) != null) {
                if (counter2 > 0) throw new RuntimeException();
                counter2++;
                z.invoke(pupil1);
            }
        }
    }
}

