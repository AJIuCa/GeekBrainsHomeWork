public class PrintRace {

    private Object object;
    private String compare;


    public PrintRace(Object object, String compare) {
        this.object = object;
        this.compare = compare;
    }

    public void printStart() {

        synchronized (object) {
            try {
                for (int i = 0; i < 3; i++) {
                    while (compare != "ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка началась!!!") {
                        object.wait();
                    }
                    System.out.print("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка началась!!!");
//                    compare = "ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка началась!!!";
                    object.notifyAll();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}