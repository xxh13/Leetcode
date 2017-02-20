package currency;

import java.util.concurrent.*;

/**
 * 线程调度demo
 * Created by XXH on 2016/5/12.
 */
public class ScheduleExecutorServiceDemo {

    public static void main(String args[]) throws Exception{
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(3);
        executorService.scheduleAtFixedRate( () -> {
            System.out.println(Thread.currentThread().getName() + "->" + System.currentTimeMillis());
            try {
                Thread.sleep(2000L);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, 1, 1, TimeUnit.SECONDS);

        executorService.scheduleWithFixedDelay( () -> {
            System.out.println(Thread.currentThread().getName() + "->" + System.currentTimeMillis());
        }, 1, 1, TimeUnit.SECONDS);

        Thread.sleep(5000L);
        executorService.shutdown();
    }

}
