package concurrent_programming.concurrent_collection.concurrenthashmap;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class App_2 {
    public static void main(String[] args) {
        ConcurrentHashMap c = new ConcurrentHashMap();
        Object k = new Object();
        Object v = new Object();
        c.put(k, v);
        AtomicInteger i = new AtomicInteger();
        i.compareAndSet(1,2);

    }
}
