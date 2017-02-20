package currency;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * Created by XXH on 2016/5/3.
 */
public class CurrencyDemo2 {

    public static void main(String args[]) throws Exception{
        Runnable task = new Thread(() ->{
            System.out.println("hello world");
        });
        System.out.println(timecost(10, task));
    }

    public static long timecost(final int times, final Runnable task) throws Exception{
        if ( times < 0) throw new IllegalArgumentException();

        final CountDownLatch startLatch = new CountDownLatch(1);
        final CountDownLatch overLatch = new CountDownLatch(times);

        for (int i = 0; i  < times; i++){
            new Thread( () -> {
                try {
                    startLatch.await();
                    task.run();
                }catch (InterruptedException e){
                    Thread.currentThread().interrupt();
                }finally {
                    overLatch.countDown();
                    System.out.println(overLatch.getCount());
                }
            }).start();
        }


        long start = System.nanoTime();
        startLatch.countDown();
        overLatch.await();
        System.out.println("end!");
        return System.nanoTime() - start;
    }

}
