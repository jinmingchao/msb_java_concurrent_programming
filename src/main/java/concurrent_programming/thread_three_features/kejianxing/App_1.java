package concurrent_programming.thread_three_features.kejianxing;

/**
 *   多核cpu操作同一数据会产生数据可见性的问题
 *   即一个核心修改了数据(flag)，另外一个核心仍然会使用自己高速缓存中的数据
 *
 *
 *
 */
public class App_1 {
    private static boolean flag = true; //T1线程在主线程将flag改成false后，并没有结束

    public static void main(String[] args) throws InterruptedException {

        Thread t1 = new Thread(()->{
            System.out.println("T1 线程开始.");
            while (flag);
            System.out.println("T1 线程结束.");
        });
        t1.start();
        Thread.sleep(2000);
        flag = false;
        System.out.println("主线程结束.");
    }
}
