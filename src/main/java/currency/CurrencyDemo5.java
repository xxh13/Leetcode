package currency;

import java.util.concurrent.*;

/**
 *
 * Created by XXH on 2016/5/9.
 */
public class CurrencyDemo5 {

    private CurrencyDemo5() {}


//    SynchronousQueue
    private static final ConcurrentMap<String, CurrencyDemo5> map = new ConcurrentHashMap<>();
    private static CurrencyDemo5 instance;

    public static CurrencyDemo5 getInstance(){
        if(instance == null){
            map.putIfAbsent("instance", new CurrencyDemo5());

            instance = map.get("instance");
        }

        return instance;
    }
}
