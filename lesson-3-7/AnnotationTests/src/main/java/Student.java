

public class Student {

    private  String name;
    private  int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @MethodsTest
    public  void learn () {

        System.out.printf("Student %s going to lessons", name);

    }

    @MethodsTest
    public void drink () {

        System.out.printf("\nStudent %s want drink, but he can't buy some beer. Because he is %d years old. " +
                "Our student very sad.", name, age);

    }

    @MethodsTest
    public  void work () {

        System.out.printf("\nStudent %s after lesson going to work",name);

    }

}
