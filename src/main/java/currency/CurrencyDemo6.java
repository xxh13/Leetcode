package currency;

import java.lang.reflect.Field;
import java.util.Timer;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 线程池任务拒绝策略 (4 types)
 * Created by XXH on 2016/5/12.
 */
public class CurrencyDemo6 {

    static void log(String msg){
        System.out.println(System.currentTimeMillis() + "->" + msg);
    }

//    Timer/**/
    static int getThreadPoolRunState(ThreadPoolExecutor pool) throws Exception{
        Field f = ThreadPoolExecutor.class.getField("state");
        f.setAccessible(true);
        int v = f.getInt(pool);
        return v;
    }

    public static void main(String args[]) throws Exception{
        ThreadPoolExecutor pool = new ThreadPoolExecutor(1, 1, 0, TimeUnit.SECONDS,
                new ArrayBlockingQueue<Runnable>(1));

        pool.setRejectedExecutionHandler(new ThreadPoolExecutor.AbortPolicy());

        for (int i=0; i< 10; i++){
            final int index = i;
            pool.submit(() -> {
                log("run task:" + index + "->" + Thread.currentThread().getName());
                try {
                    Thread.sleep(1000L);
                } catch (Exception e){
                    e.printStackTrace();
                }
                log("run over:" + index + "->" + Thread.currentThread().getName());
            });
        }
        log("before sleep");
        Thread.sleep(4000L);
        log("before shutdown");
        pool.shutdown();
        log("after shutdown,pool.terminate=" + pool.isTerminated());
        pool.awaitTermination(1000L, TimeUnit.SECONDS);
        log("now, pool.isTerminated=" + pool.isTerminated() + ", state=");
    }
}
