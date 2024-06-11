package concurrent_programming.concurrent_collection.concurrenthashmap;

import sun.misc.Unsafe;

import java.util.concurrent.ConcurrentHashMap;

public class App_1 {
    public static void main(String[] args) {
        // 1
//        ConcurrentHashMap<Integer, Integer> map = new ConcurrentHashMap();
//        map.put(6,9);
//        //Unsafe.//看看这个类
//        Integer i = 245;
//        System.out.println(i.hashCode());
        // 2. compute()
//        ConcurrentHashMap<Integer, Integer> map = new ConcurrentHashMap<>();
//        map.compute(123, (k,v)->{
//            return 1234;
//        });
//        System.out.println();
        // 3. compute() 的 逻辑问题, 这样的代码会让内部的compute方法执行不能结束，因为逻辑上没有给它出口
//        ConcurrentHashMap<Integer, Integer> map = new ConcurrentHashMap<>();
//        map.compute(123,(key, oldval)->{
//                return map.compute(123, (k, v)->{
//                    return 1111;
//                });
//        });
//        System.out.println();
        //4. replace() ，cas替换
//        ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();
//        int oldVal = 0;
//        int newVal = 1;
//        map.replace("key", 0 ,1 );
    }
}
