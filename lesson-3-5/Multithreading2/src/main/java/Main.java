
// 1. Создать три потока, каждый из которых выводит определенную букву (A, B и C) 5 раз (порядок – ABСABСABС).
//      Используйте wait/notify/notifyAll.
// 2. Приведённый код перенести в новый проект.
//    Организуем гонки:
//     Все участники должны стартовать одновременно, несмотря на то, что на подготовку у каждого из них уходит разное время.
//     В туннель не может заехать одновременно больше половины участников (условность).
//     Попробуйте всё это синхронизировать.
//     Только после того как все завершат гонку, нужно выдать объявление об окончании.
//      Можете корректировать классы (в т.ч. конструктор машин) и добавлять объекты классов из пакета util.concurrent.


import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

public class Main {

    static final int CARS_COUNT = 4;

    static CyclicBarrier cb1 = Car.cb1;
    static CountDownLatch finish = Car.finish;
    static  CountDownLatch readyToRace = Car.readyToRace;
    static int time = Car.raceTime;


    public static void main(String[] args) throws InterruptedException, BrokenBarrierException {

        startApp();
        
    }

    public static void startApp() throws InterruptedException, BrokenBarrierException {

        consecutiveThreads();
        Thread.sleep(200);


        System.out.println("\n-----------------------------------------------------------------");

        carRacing();

    }

    public static void consecutiveThreads() {

        Object a = new Object();

        Printing print = new Printing(a, 'A');

        Thread t7 = new Thread(() -> {
            print.printA();
        });
        Thread t8 = new Thread(() -> {
            print.printB();
        });
        Thread t9 = new Thread(() -> {
            print.printC();
        });
        t7.start();
        t8.start();
        t9.start();
    }

    public static void carRacing() throws InterruptedException, BrokenBarrierException {


        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Подготовка!!!");

        Race race = new Race(new Road(60), new Tunnel(), new Road(40));
        Car[] cars = new Car[CARS_COUNT];
        for (int i = 0; i < cars.length; i++) {
            cars[i] = new Car(race, 20 + (int) (Math.random() * 10));
        }
//        for (int i = 0; i < cars.length; i++) {
//
//            finish.getCount();
//            new Thread(cars[i]).start();
//
//
//        }


            finish.getCount();

            long startRace1 = System.currentTimeMillis();
            new Thread(cars[0]).start();
            long endRace1 = System.currentTimeMillis();

            long startRace2 = System.currentTimeMillis();
            new Thread(cars[1]).start();
            long endRace2 = System.currentTimeMillis();

            long startRace3 = System.currentTimeMillis();
            new Thread(cars[2]).start();
            long endRace3 = System.currentTimeMillis();

            long startRace4 = System.currentTimeMillis();
            new Thread(cars[3]).start();
            long endRace4 = System.currentTimeMillis();

            long totalRaceTime1 = endRace1 - startRace1;
            long totalRaceTime2 = endRace2 - startRace2;
            long totalRaceTime3 = endRace3 - startRace3;
            long totalRaceTime4 = endRace4 - startRace4;






        while (readyToRace.getCount() != 0) {

            Thread.sleep(10);

            if (readyToRace.getCount() == 0) {

                System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка началась!!!");
            }
        }

        while (finish.getCount() != 0) {

            try {
                Thread.sleep(15000);

                if (totalRaceTime1>totalRaceTime2 && totalRaceTime1>totalRaceTime3 && totalRaceTime1>totalRaceTime4) {
                    System.out.println("Выграл гонищик №1. Время гонки = "+totalRaceTime1);
                } else if (totalRaceTime2>totalRaceTime1 && totalRaceTime2>totalRaceTime3 && totalRaceTime2>totalRaceTime4) {
                    System.out.println("Выграл гонищик №2. Время гонки = " + totalRaceTime2);
                } else if (totalRaceTime3>totalRaceTime1 && totalRaceTime3>totalRaceTime2 && totalRaceTime3>totalRaceTime4) {
                    System.out.println("Выграл гонищик №3. Время гонки = " + totalRaceTime3);
                } else if (totalRaceTime4>totalRaceTime1 && totalRaceTime4>totalRaceTime2 && totalRaceTime4>totalRaceTime3) {
                    System.out.println("Выграл гонищик №4. Время гонки = " + totalRaceTime4);
                }

            } catch (InterruptedException e) {

            }

            System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка закончилась!!!");
                break;
            }
        }
    }






