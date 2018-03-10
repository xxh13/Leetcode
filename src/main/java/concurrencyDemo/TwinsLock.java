package concurrencyDemo;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;

public class TwinsLock {

    private final Syc syc = new Syc(2);

    private static class Syc extends AbstractQueuedSynchronizer {

        Syc(int count) {
            if (count < 0) {
                throw new IllegalArgumentException("count must large than zero");
            }
            setState(count);
        }

        @Override
        protected boolean tryReleaseShared(int arg) {
            for (;;) {
                int current = getState();
                int newCount = current + arg;
                if (compareAndSetState(current, newCount)) {
                    return true;
                }
            }
        }

        @Override
        protected int tryAcquireShared(int arg) {
            for (;;) {
                int current = getState();
                int newCount = current - arg;
                if (newCount < 0 || compareAndSetState(current, newCount)) {
                    return newCount;
                }
            }
        }

    }

    public void lock() {
        syc.acquireShared(1);
    }

    public void unlock() {
        syc.releaseShared(1);
    }
}
