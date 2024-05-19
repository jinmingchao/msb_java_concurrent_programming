package concurrent_programming.lock.locjkupgrade;

import org.openjdk.jol.info.ClassLayout;

public class App_3 {
    public static void main(String[] args) throws InterruptedException {
        Object o = new Object();
        System.out.println(ClassLayout.parseInstance(o).toPrintable());

        Thread.sleep(1000);
        synchronized (o) {
            System.out.println(ClassLayout.parseInstance(o).toPrintable());
        }
    }
}
