import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TestClass {

    static Method [] studentMethods = Student.class.getDeclaredMethods();

    public static void methodsList () {

        System.out.println("methods list");


        for (Method i : studentMethods) {
            System.out.println(i.getName());
        }
        System.out.println("");
    }


    public static void startTest () throws InvocationTargetException, IllegalAccessException {

        TestClass test = new TestClass();
//        Student st = new Student();

        for (Method z : studentMethods) {
            if (z.getAnnotation(MethodsTest.class) != null) {
                z.invoke(test);
                System.out.println("adasd");
            }
        }
    }
}
