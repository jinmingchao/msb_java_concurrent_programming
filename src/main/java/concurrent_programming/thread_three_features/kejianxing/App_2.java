package concurrent_programming.thread_three_features.kejianxing;

/**
 *   多核cpu操作同一数据会产生数据可见性的问题
 *   即一个核心修改了数据(flag)，另外一个核心仍然会使用自己高速缓存中的数据
 *
 *   加入volatile关键字，就可以解决这个问题:
 *      对于加了volatile关键字修饰的变量:
 *      cpu读的时候，JMM让对应变量在高速缓存中的缓存失效，直接从内存里读
 *      cpu写的时候，JMM会及时写到主内存中
 *
 */
public class App_2 {
    private static volatile boolean flag = true; //T1线程在主线程将flag改成false后，并没有结束

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
