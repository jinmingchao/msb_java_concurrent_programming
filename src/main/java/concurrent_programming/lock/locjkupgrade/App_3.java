package concurrent_programming.lock.locjkupgrade;

import org.openjdk.jol.info.ClassLayout;

/**
 *
 * 为了提高ClassLoader的加载效率，jdk1.8在前5s默认关闭轻量级锁
 *
 *
 */
public class App_3 {
    public static void main(String[] args) throws InterruptedException {
        Thread.sleep(5000); //关闭轻量级锁测试
        Object o = new Object();
        System.out.println(ClassLayout.parseInstance(o).toPrintable());

        synchronized (o) {
            System.out.println(ClassLayout.parseInstance(o).toPrintable());
        }
    }
}
