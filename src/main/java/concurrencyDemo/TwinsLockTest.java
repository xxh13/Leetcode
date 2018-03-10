package concurrencyDemo;

public class TwinsLockTest {

    final static TwinsLock lock = new TwinsLock();

    public static void main(String[] args) throws Exception{
        test();
    }

    public static void test() throws Exception{
        for (int i = 0; i < 10; i++) {
            Worker w = new Worker();
//            w.setDaemon(true);
            w.start();
        }

//        for (int i = 0; i < 10; i++) {
//            Thread.sleep(1000);
//            System.out.println();
//        }
    }

    static class Worker extends Thread {
        @Override
        public void run() {
            while (true) {
                lock.lock();
                try {
                    Thread.sleep(1000);
                    System.out.println(Thread.currentThread().getName());
                } catch (InterruptedException e) {

                } finally {
                    lock.unlock();
                }
            }
        }
    }
}
