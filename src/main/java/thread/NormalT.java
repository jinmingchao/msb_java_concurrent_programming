package thread;

import java.util.concurrent.TimeUnit;

public class NormalT implements Runnable{

    @Override
    public void run() {
        System.out.println("Hello World.");
        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("GoodBye World.");
    }
}
