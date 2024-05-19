package thread.date0712.interrupt;

import java.util.concurrent.TimeUnit;

public class App1 {
    public static void main(String[] args) {
        Thread t1 = new Thread(new T1());
        t1.start();
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t1.interrupt(); // set t1.isInterrupted() = true;
        //Thread.interrupted();
    }
}

class T1 implements Runnable {

    @Override
    public void run() {
        int i = 0;
        while (!Thread.currentThread().isInterrupted()) {
            i++;
        }
        System.out.println("i: " + i);
    }
}
