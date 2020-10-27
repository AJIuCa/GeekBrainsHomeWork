package ru.geekbrains.lesson_2_1;

//  1. Создайте три класса Человек, Кот, Робот, которые не наследуются от одного класса. Эти классы должны уметь
//      бегать и прыгать (методы просто выводят информацию о действии в консоль).
//  2. Создайте два класса: беговая дорожка и стена, при прохождении через которые, участники должны выполнять
//      соответствующие действия (бежать или прыгать), результат выполнения печатаем в консоль
//      (успешно пробежал, не смог пробежать и т.д.).
//  3. Создайте два массива: с участниками и препятствиями, и заставьте всех участников пройти этот набор препятствий.
//  4.* У препятствий есть длина (для дорожки) или высота (для стены), а участников ограничения на бег и прыжки.
//      Если участник не смог пройти одно из препятствий, то дальше по списку он препятствий не идет.


public class Main {

    public static void main(String[] args) {
        startApp();
    }

    public static void startApp() {
        human(wall(), runningTrack());
        cat(wall(), runningTrack());
        robot(wall(), runningTrack());
        competition(barriers(), participants(), runningTrack());
    }

    public static Wall wall() {
        Wall wall1 = new Wall(1);
        return wall1;
    }

    public static RunningTrack runningTrack() {
        RunningTrack runningTrack1 = new RunningTrack(2);
        return runningTrack1;
    }
    
    public static void human(Wall wall1, RunningTrack runningTrack1) {
        Human human1 = new Human("Oleg", 1, 5);
        System.out.print(String.format("%s wants to run on the running track. Track lenght %s km.", human1.getName(), runningTrack1.getLength()));
        if (human1.getRunningSkill() >= runningTrack1.getLength()) {
            System.out.println(String.format(" %s has enough skill to run this distance.", human1.getName()));
            human1.run();
        } else {
            System.out.println(String.format("%s cant run this distance.", human1.getName()));
        }
        System.out.print(String.format("%s see a wall in front of him.", human1.getName()));
        if (human1.getRunningSkill() >= wall1.getHeight()) {
            System.out.println(String.format(" %s can jump over this wall.", human1.getName()));
            human1.jump();
        } else {
            System.out.println(String.format(" %s cant jump so high.", human1.getName()));
        }
        System.out.println("\n");
    }

    public static void cat(Wall wall1, RunningTrack runningTrack1) {
        Cat cat1 = new Cat("Alice", 3, 3);
        System.out.print(String.format("%s wants to run on the running track. Track lenght %s km.", cat1.getName(), runningTrack1.getLength()));
        if (cat1.getRunningSkill() >= runningTrack1.getLength()) {
            System.out.println(String.format(" %s has enough skill to run this distance.", cat1.getName()));
            cat1.run();
        } else {
            System.out.println(String.format("%s cant run this distance.", cat1.getName()));
        }
        System.out.print(String.format("%s see a wall in front of him.", cat1.getName()));
        if (cat1.getRunningSkill() >= wall1.getHeight()) {
            System.out.println(String.format(" %s can jump over this wall.", cat1.getName()));
            cat1.jump();
        } else {
            System.out.println(String.format(" %s cant jump so high.", cat1.getName()));
        }
        System.out.println("\n");
    }

    public static void robot(Wall wall1, RunningTrack runningTrack1) {
        Robot robot1 = new Robot("C3PO", 0, 1);
        System.out.println(String.format("%s wants to run on the running track. Track lenght %s km.", robot1.getName(), runningTrack1.getLength()));
        if (robot1.getRunningSkill() >= runningTrack1.getLength()) {
            System.out.println(String.format(" %s has enough skill to run this distance.", robot1.getName()));
            robot1.run();
        } else {
            System.out.println(String.format("%s cant run this distance.", robot1.getName()));
        }
        System.out.println(String.format("%s see a wall in front of him.", robot1.getName()));
        if (robot1.getJumpingSkill() >= wall1.getHeight()) {
            System.out.println(String.format("%s can jump over this wall.", robot1.getName()));
            robot1.jump();
        } else {
            System.out.println(String.format("%s cant jump so high.", robot1.getName()));
        }
        System.out.println("\n");
    }

    public static Wall[] barriers() {
        Wall[] barrier = new Wall[2];
        barrier[0] = new Wall(1);
        barrier[1] = new Wall(3);
        return barrier;
    }

    public static Human[] participants() {
        Human[] participant = new Human[3];
        participant[0] = new Human("Kostya", 1, 3);
        participant[1] = new Human("Trevor", 2, 1);
        participant[2] = new Human("Angron", 3, 5);
        return participant;
    }

    public static void competition(Wall barrier[], Human participant[], RunningTrack runningTrack1) {
        System.out.println(String.format("%s, %s and %s participate in our competition", participant[0].getName(), participant[1].getName(), participant[2].getName()));

        for (int i = 0; i < participant.length; i++) {

            if (participant[i].getJumpingSkill() >= barrier[0].getHeight()) {
                participant[i].jump();
                System.out.println(String.format("%s successfully overcomes obstacle. The next test is a distance run.", participant[i].getName()));
                if (participant[i].getRunningSkill() >= runningTrack1.getLength()) {
                    participant[i].run();
                    System.out.println(String.format("%s successfully ran the distance. The last test is a wall.", participant[i].getName()));
                    if (participant[i].getJumpingSkill() >= barrier[1].getHeight()) {
                        participant[i].jump();
                        System.out.println(String.format("%s successfully overcomes obstacle.", participant[i].getName()));
                        System.out.println(String.format("%s successfully passed all tests.\n", participant[i].getName()));
                    } else {
                        System.out.println(String.format("%s drops out of the competition.\n", participant[i].getName()));
                    }
                } else {
                    System.out.println(String.format("%s drops out of the competition.\n", participant[i].getName()));
                }
            } else {
                System.out.println(String.format("%s drops out of the competition.\n", participant[i].getName()));
            }

        }
    }
}
