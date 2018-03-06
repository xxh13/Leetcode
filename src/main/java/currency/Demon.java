package currency;

public class Demon {

    public static void main(String[] args) {
        Thread thread = new Thread(new DemonRunner(), "DemonRunner");
        thread.setDaemon(true);
        thread.start();
    }

    static class DemonRunner implements Runnable {
        @Override
        public void run() {
            try {
                Thread.sleep(10000);
            } catch (Exception e) {
                e.printStackTrace();
            }
            finally {
                System.out.println("hello");
            }
        }
    }
}
