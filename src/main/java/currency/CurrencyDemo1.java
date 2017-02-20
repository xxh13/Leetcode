package currency;


/**
 *
 * Created by XXH on 2016/4/21.
 */
public class CurrencyDemo1{

    static void threadMessage(String message){
        String threadName = Thread.currentThread().getName();
        System.out.format("%s: %s%n", threadName,message);
    }

    private static class MessageLoop implements Runnable{

        @Override
        public void run() {
            String messages[] = {
                    "ni",
                    "hao",
                    "china",
                    "town"
            };
            try {
                for (String message : messages) {
                    Thread.sleep(4000);
                    threadMessage(message);
                }
            }catch (InterruptedException e){
                threadMessage("I wasn't done!");
            }
        }
    }

    public static void main(String args[]) throws Exception{
        long patience = 1000 * 6;
        threadMessage("starting messageLoop thread");
        long startTime = System.currentTimeMillis();
        Thread t = new Thread(new MessageLoop());
        t.start();
        threadMessage("Waiting for messageLoop thread to finish");

        while (t.isAlive()){
            threadMessage("still waiting...");
            t.join(1000);
            if (((System.currentTimeMillis() - startTime) > patience) && t.isAlive()){
                threadMessage("tired of waiting!");
                t.interrupt();
                t.join();
                threadMessage("messageLoop thread die!!!");
            }
        }
        threadMessage("finally");
    }
}

