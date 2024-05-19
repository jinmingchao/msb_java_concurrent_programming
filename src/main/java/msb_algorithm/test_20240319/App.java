package msb_algorithm.test_20240319;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class App {
    String aa = "abc";
    static String aa_static = "aa_static";
    static Map<String, String> m = new HashMap<>();

    static {
        m.put("abc","abc_value");
    }
    public static void main(String[] args) throws InterruptedException {
//        String a1 = new String("abc");
//        String a2 = new String("abc");
//        String a3 = new String("abc");
//        System.out.println(a1 == a2);
//        System.out.println(a1 == a2.intern());
//        System.out.println(a1.intern() == a2.intern());
//        System.out.println(a3 == a2);
//        System.out.println(a1 == a3);
//        String a4 = "abc";
//        String a5 = "abc";
//        System.out.println(a4 == a5);
//        System.out.println(a4 == a5.intern());
//        String a6 = "abc";
//        String a7 = new String("abc");
//        System.out.println(a6 == a7.intern());
//        System.out.println(a6.intern() == a7);

        new App().method_1(10000);
//TODO        如果一个对象静态化了, 那么里面的字段内容都会静态化吗？ -> 会的

    }

    Thread[] method_1(int numOfThreads) {

        Thread[] threadsArray = new Thread[numOfThreads];
        for (int i = 0; i < numOfThreads; i++) {
            threadsArray[i] = new Thread(() -> {
                List<String> l = new LinkedList<>();
                while (true) {
                    //1
                    String a = new String("abc");
                    //2
//                    String a = "abc";
                    //3
//                    String a = aa.intern();
                    //4
//                    String a = aa_static;
                    //5
//                    String a = aa_static.intern();
                    //6
//                    String a = m.get("abc");
                    l.add(a);
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
            threadsArray[i].start();
        }
        return threadsArray;
    }
}
