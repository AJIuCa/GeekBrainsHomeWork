import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Test {

    public void startTest(Class aClass) throws RuntimeException, IllegalAccessException, InstantiationException, InvocationTargetException {

        Object o = aClass.newInstance();
        Method[] pupilMethods = o.getClass().getDeclaredMethods();

        List<Method> list = new ArrayList<>();
        Method before = null;
        Method after = null;
        int counter1 = 0;
        int counter2 = 0;


        for (Method m : pupilMethods) {
            if (m.isAnnotationPresent(TestMethods.class)) {
                list.add(m);
            }
        }

        list.sort(new Comparator<Method>() {
            @Override
            public int compare(Method o1, Method o2) {
                return o2.getAnnotation(TestMethods.class).order() - o1.getAnnotation(TestMethods.class).order();
            }
        });

        for (Method m : pupilMethods) {
            if (m.isAnnotationPresent(BeforeSuite.class)) {
                before = m;
                counter1++;
            }
            if (m.isAnnotationPresent(AfterSuite.class)) {
                after = m;
                counter2++;
            }
            if(counter1 > 1 || counter2 > 1) {
                throw new RuntimeException();
            }
        }

        if (before != null) {
            list.add(0, before);
        }

        if (after != null) {
            list.add(after);
        }


        list.forEach(m -> {
            try {
                m.invoke(o, null);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        });


    }
}

