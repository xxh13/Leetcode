package currency;

import javafx.concurrent.Task;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class AsynomasDemo {

    public static class Task implements Callable<String> {
        @Override
        public String call() throws Exception {
            System.out.println("execute!!!");
            return "complete";
        }
    }

    public static void main(String[] args) throws Exception{
        List<Future<String>> results = new ArrayList<>();
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            results.add(executorService.submit(new Task()));
        }

        for (Future<String> future : results) {
            System.out.println(future.get());
        }

        System.out.println("Main complete");

        if (!executorService.isShutdown()) {
            executorService.shutdown();
        }
    }
}
