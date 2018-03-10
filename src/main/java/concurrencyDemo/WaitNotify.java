package concurrencyDemo;

public class WaitNotify {

    static boolean flag = true;
    static final Object lock = new Object();

    public static void main(String[] args) throws InterruptedException{
        Thread waitThread = new Thread(new WaitThread(), "wait thread");
        Thread notifyThread = new Thread(new NotifyThread(), "notify thread");
        waitThread.start();
        Thread.sleep(1000);
        notifyThread.start();
    }

    static class WaitThread implements Runnable {
        @Override
        public void run() {
            synchronized (lock) {
                while (flag) {
                    try {
                        System.out.println(Thread.currentThread() + " flag is true, wait");
                        lock.wait();
                    } catch (InterruptedException e) {

                    }
                }
                System.out.println(Thread.currentThread() + " flag is false. running");
            }
        }
    }

    static class NotifyThread implements Runnable {
        @Override
        public void run() {
            synchronized (lock) {
                try {
                    System.out.println(Thread.currentThread() + " hold lock");
                    lock.notifyAll();
                    flag = false;
                    Thread.sleep(5000);
                } catch (InterruptedException e) {

                }
            }
            for (int i = 0; i < 10000; i++){}
            synchronized (lock) {
                System.out.println(Thread.currentThread() + " hold lock again");
            }
        }
    }
}
