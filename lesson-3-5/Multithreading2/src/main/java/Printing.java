
public class Printing {

    private Object object;
    private char compare;

    public Printing(Object object, char compare) {
        this.object = object;
        this.compare = compare;
    }

    public void printA() {

        synchronized (object) {
            try {
                for (int i = 0; i < 3; i++) {
                    while (compare != 'A') {
                        object.wait();
                    }
                    System.out.print("A");
                    compare = 'B';
                    object.notifyAll();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void printB() {


        synchronized (object) {
            try {
                for (int i = 0; i < 3; i++) {
                    while (compare != 'B') {
                        object.wait();
                    }
                    System.out.print("B");
                    compare = 'C';
                    object.notifyAll();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void printC() {

        synchronized (object) {
            try {
                for (int i = 0; i < 3; i++) {
                    while (compare != 'C') {
                        object.wait();
                    }
                    System.out.print("C");
                    compare = 'A';
                    object.notifyAll();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


}
