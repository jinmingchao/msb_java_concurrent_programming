package concurrent_programming.thread_three_features.kejianxing;

/**
 **
 *   在操作volatile修饰的变量是 (本例中的 int i)
 *   在操作他的同时，也会直接影响到其他的变量
 *   在i++时，也同样会刷新t1线程对flag的缓存，使他变成最新的数据
 *
 */
public class App_2_1 {
    private static boolean flag = true; //T1线程在主线程将flag改成false后，并没有结束

    private static volatile int i = 0; //
    public static void main(String[] args) throws InterruptedException {

        Thread t1 = new Thread(()->{
            System.out.println("T1 线程开始.");
            while (flag) {
                i++;
            }
            System.out.println("T1 线程结束.");
        });
        t1.start();
        Thread.sleep(2000);
        flag = false;
        System.out.println("主线程将flag修改为false");
        System.out.println("主线程结束.");
    }
}
