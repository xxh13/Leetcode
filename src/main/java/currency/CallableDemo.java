package currency;

import java.util.concurrent.*;

/**
 * callable interface demo test
 * Created by XXH on 2016/5/15.
 */
public class CallableDemo {

    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();
        Task task = new Task();
        FutureTask<Integer> futureTask = new FutureTask<>(task);
        executor.submit(futureTask);
        executor.shutdown();

        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("the main thread is executing task");

        try {
            System.out.println("the result of task is " + futureTask.get() );
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        System.out.println("all tasks is done!");
    }
}


class Task implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        System.out.println("the sub thread is calculating....");
        Thread.sleep(3000);
        int sum = 0;
        for (int i = 0; i < 100; i++) {
            sum += i;
        }

        return sum;
    }
}
