package currency;

public class LockDemo {

    public static void main(String[] args) {
        LockDemo demo = new LockDemo();
        LockDemo demo1 = new LockDemo();

        Thread t1 = new Thread(() -> demo.print1("hello"));
        Thread t2 = new Thread(() -> demo.print1("hello"));

        t1.start();
        t2.start();

        System.out.println("world");
    }


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
