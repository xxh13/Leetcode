package currency;

import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.ScheduledThreadPoolExecutor;

/**
 *
 * Created by XXH on 2016/5/15.
 */
public class SleepForResultDemo implements Runnable{

    static boolean result = false;

    static void sleepWhile(long ms) {
        try{
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        System.out.println("Hello sleep for a while");
        sleepWhile(2000L);
        result = true;
//        ScheduledThreadPoolExecutor
    }

    public static void main(String args[]) throws InterruptedException{
        SleepForResultDemo demo = new SleepForResultDemo();
        Thread t = new Thread(demo);
        t.start();
        t.join();
        System.out.println(result);
    }
}
