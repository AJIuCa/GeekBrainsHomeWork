import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

public class Car implements Runnable {


    private static int CARS_COUNT = 0;

    private static int countForCountDown = 4;

//    private static CyclicBarrier cb1 = Main.cb1;
//    private static CountDownLatch finish = Main.finish;
//    private static CountDownLatch readyToRace = Main.readyToRace;


    static final  CyclicBarrier cb1 = new CyclicBarrier(countForCountDown);
    static final CountDownLatch finish = new CountDownLatch(countForCountDown);
    static final CountDownLatch readyToRace = new CountDownLatch(countForCountDown);

    static int raceTime;


    private Race race;
    private int speed;
    private String name;


    public String getName() {
        return name;
    }

    public int getSpeed() {
        return speed;
    }

    public Car(Race race, int speed) {
        this.race = race;
        this.speed = speed;
        CARS_COUNT++;
        this.name = "Участник #" + CARS_COUNT;
    }

    @Override
    public void run() {

            try {

                System.out.println(this.name + " готовится");
                Thread.sleep(100 + (int) (Math.random() * 800));
                Main.readyToRace.countDown();

                System.out.println(this.name + " готов");

            } catch (Exception e) {
                e.printStackTrace();
            }

        int startTime = (int) System.currentTimeMillis();

        for (int i = 0; i < race.getStages().size(); i++) {


            try {
                Thread.sleep(550 + (int) (Math.random() * 800));
                race.getStages().get(i).go(this);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
        int endTime = (int) System.currentTimeMillis();

        raceTime = endTime-startTime;
//        System.out.println(time);
    }



}
