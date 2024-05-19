package thread.date0712.interrupt;

import java.util.concurrent.TimeUnit;

public class App3 {

    public static void main(String[] args) {
        Thread t3 = new Thread(new T3());
        t3.start();
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {

        }

        System.out.println("打断");
        t3.interrupt(); // set t1.isInterrupted() = true;
    }
}

class T3 implements Runnable {

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            System.out.println("T3 do sleeping.");
            try {
                TimeUnit.SECONDS.sleep(10);
            } catch (InterruptedException e) {
                // 被打断以后 会将 t3.isInterrupted() = false
                e.printStackTrace();
                System.out.println("after: " + Thread.currentThread().isInterrupted());
            }
        }
        System.out.println("T3 end.");
    }
}
