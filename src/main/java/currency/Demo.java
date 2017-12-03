package currency;


public class Demo {

    private final Object lock = new Object();

    public void print1(String s) {
        synchronized (lock) {
            System.out.println(s);
            try {
                Thread.sleep(5000);
            } catch (Exception e) {}
        }
    }

    public void print2(String s) {
        System.out.println(s);
    }
}
