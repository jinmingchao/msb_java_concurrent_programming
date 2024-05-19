package concurrent_programming.thread_three_features.kejianxing;

/**
 *  sync关键字也能解决这个问题
 *  sout也可以，因为里面带有sync关键字
 *  在获取锁的时候，会将所有主内存的变量都刷新一次
 */
public class App_3 {
    private static boolean flag = true; //使用sync关键字时，也会刷新相关变量

    public static void main(String[] args) throws InterruptedException {

        Thread t1 = new Thread(()->{
            System.out.println("T1 线程开始.");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            synchronized (App_3.class) {
                    while (flag){
                    System.out.println("...");
                 }
            }
            System.out.println("T1 线程结束.");
        });
        t1.start();
        Thread.sleep(500);
        flag = false;
        System.out.println("主线程结束.");
    }
}
