package concurrent_programming.concurrent_collection.concurrenthashmap;

import sun.misc.Unsafe;

import java.util.concurrent.ConcurrentHashMap;

public class App_1 {
    public static void main(String[] args) {
        ConcurrentHashMap<Integer, Integer> map = new ConcurrentHashMap();
        map.put(6,9);
        //Unsafe.//看看这个类
        Integer i = 245;
        System.out.println(i.hashCode());
    }
}
