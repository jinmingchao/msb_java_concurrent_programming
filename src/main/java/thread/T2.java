package thread;

import java.util.concurrent.TimeUnit;

public class T2 implements Runnable{

    @Override
    public void run() {
        System.out.println("T2 start");
        System.out.println("T2 sleep");
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("T2 do notifying");
        synchronized (this) {
            Main.lock.notify();
        }
        System.out.println("T2 end");

    }
}
