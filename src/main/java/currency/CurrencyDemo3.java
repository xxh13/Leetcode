package currency;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/**
 *
 * Created by XXH on 2016/4/25.
 */
public class CurrencyDemo3 {

    class DemoData {
        public volatile int value1 = 1;
        volatile int value2 = 2;
        protected volatile int value3 = 3;
        private volatile int value4 = 4;
    }

    AtomicIntegerFieldUpdater<DemoData> getUpdater(String fieldName){
        return AtomicIntegerFieldUpdater.newUpdater(DemoData.class, fieldName);
    }

    void doit(){
        DemoData data = new DemoData();
        System.out.println("1===>" + getUpdater("value1").getAndSet(data,10));
        System.out.println("11===>" + getUpdater("value1").incrementAndGet(data));
        System.out.println("11===>" + getUpdater("value1").compareAndSet(data,11,14));
    }

    public static void main(String args[]){
        CurrencyDemo3 demo = new CurrencyDemo3();
        demo.doit();
    }
}
