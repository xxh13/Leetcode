package currency;

/**
 *
 * Created by XXH on 2016/5/5.
 */
public class CurrencyDemo4 {
    public static volatile boolean stopRequest;

    public static void main(String args[]) throws InterruptedException{
        Thread backgroudThread = new Thread( () -> {
            int i = 0;
            while (!stopRequest)
                i++;

        });
        backgroudThread.start();

        Thread.sleep(1000);
        stopRequest = true;


    }

}
