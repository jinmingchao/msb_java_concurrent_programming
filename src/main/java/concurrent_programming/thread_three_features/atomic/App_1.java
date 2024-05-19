package concurrent_programming.thread_three_features.atomic;

/**
 * javac App_1.java 编译
 * javap App_1.class 反编译，输出结果
 * javap -v App_1.class 反编译，输出指令
 */
public class App_1 {

    private static volatile int count;

    public static void increment() {
        synchronized (App_1.class) {
            count++;
        }
    }
}
