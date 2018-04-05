package currency;


public class Demo {

    private final Object lock = new Object();
    ThreadLocal<String> threadLocal = new ThreadLocal<>();
    ThreadLocal<Integer> threadLocal1 = new ThreadLocal<>();

    public void print1(String s) {
        threadLocal.set("asdas");
        threadLocal1.set(1);
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
