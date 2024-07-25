package thread.date0719.Volatile;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class App_2 {

    static AtomicInteger i = new AtomicInteger(0);
    static int i1 = 0;
    public static void main(String[] args) throws InterruptedException {

       Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int j = 0; j < 10000; j++) {
                    i.addAndGet(1);
                    i1++;
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int j = 0; j < 10000; j++) {
                    i.addAndGet(1);
                    i1++;
                }
            }
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(i.get());
        System.out.println(i1);

    }


}
