package concurrent_programming.lock.locjkupgrade;

import org.openjdk.jol.info.ClassLayout;

/**
 *  对象锁状态; 无锁(匿名偏向) -> 偏向锁 -> 轻量级锁 -> 重量级锁
 *
 *
 */
public class App_1 {
    public static void main(String[] args) throws InterruptedException {
        Object o = new Object();
        System.out.println("STEP1 START");
        System.out.println(ClassLayout.parseInstance(o).toPrintable()); // 无锁(匿名偏向)
        System.out.println("STEP1 END");


        new Thread(()->{
            synchronized (o) {
                System.out.println("STEP2 START");
                System.out.println(ClassLayout.parseInstance(o).toPrintable()); // 偏向锁
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("STEP2 END");
            }
        }).start();

        Thread.sleep(2000);
        synchronized (o) {
            System.out.println("STEP3 START");
            System.out.println(ClassLayout.parseInstance(o).toPrintable()); // 重量级锁
            System.out.println("STEP3 START");
        }






    }
}
