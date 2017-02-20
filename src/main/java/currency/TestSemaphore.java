package currency;

import java.util.concurrent.Semaphore;

/**
 * java.util.concurrent.Semaphore
 * Created by XXH on 2016/5/5.
 */
public class TestSemaphore {

    static Warehouse buffer = new Warehouse();

    public static void main(String[] args){
        for (int i = 0; i <= 3; i++){
            new Thread(new Producer()).start();
            new Thread(new Consumer()).start();
        }
    }

    static class Warehouse {
        final Semaphore notFull = new Semaphore(10);
        final Semaphore notEmpty = new Semaphore(0);
        final Semaphore mutex = new Semaphore(1);

        final Object[] items = new Object[10];
        int putptr, takeptr, count;

        public void put(Object x) throws InterruptedException {
            notFull.acquire();
            mutex.acquire();

            try{
                items[putptr] = x;
                if (++putptr == items.length)
                    putptr = 0;
                ++count;
            }finally {
                mutex.release();
                notEmpty.release();
            }
        }

        public Object take() throws InterruptedException {
            notEmpty.acquire();
            mutex.acquire();
            try {
                Object x = items[takeptr];
                if (++takeptr == items.length)
                    takeptr = 0;
                --count;
                return x;
            }finally {
                mutex.release();
                notFull.release();
            }
        }
    }

    static class Producer implements Runnable {
        static int num = 1;
        @Override
        public void run() {
            int n = num ++;
            while (true) {
                try {
                    buffer.put(n);
                    System.out.println(">" + n);
                    Thread.sleep(2000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        }
    }

    static class Consumer implements Runnable {

        @Override
        public void run() {
            while (true){
                try {
                    System.out.println("<" + buffer.take());
                    Thread.sleep(2000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        }
    }
}
