
public class Pupil {


    private  String name;
    private  int age;

    public Pupil(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Pupil() {
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @BeforeSuite
    public void wakeUpp () {

        System.out.printf("\nPupil %s wake upp and going to brush teeth", name);

    }

    @AfterSuite
    public void drink () {

        System.out.printf("\nPupil %s want drink, but he can't buy some beer. Because he is %d years old. " +
                "Our pupil very sad.", name, age);

    }

    @TestMethods (order  = 2)
    public  void doHomeWork() {

        System.out.printf("\nPupil %s after lessons going to do home work",name);

    }

    @TestMethods (order  = 1)
    public void learn () {

        System.out.printf("\nPupil %s going to lessons", name);

    }

}
