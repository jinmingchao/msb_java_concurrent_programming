package concurrent_programming.lock.locjkupgrade;

import org.openjdk.jol.info.ClassLayout;

public class App_2 {
    public static void main(String[] args) throws InterruptedException {
        Object o = new Object();
        System.out.println(ClassLayout.parseInstance(o).toPrintable());

        new Thread(()->{
                synchronized (o){
                    System.out.println("t1 start");
                    System.out.println(ClassLayout.parseInstance(o).toPrintable());
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println("t1 end");
                }
        }).start();


        Thread.sleep(2000);
        synchronized (o) {
            System.out.println("main start");
            System.out.println(ClassLayout.parseInstance(o).toPrintable());
            System.out.println("main end");
        }
    }
}
