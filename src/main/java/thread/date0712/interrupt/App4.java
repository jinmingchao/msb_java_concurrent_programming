package thread.date0712.interrupt;

import java.util.concurrent.TimeUnit;

public class App4 {

    public static void main(String[] args) {
        Thread t4 = new Thread(new T4());
        t4.start();
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {

        }

        System.out.println("打断");
        t4.interrupt(); // set t1.isInterrupted() = true;
    }
}

class T4 implements Runnable {

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) { //通过t4.interrupt() 打断, 从而达到跳出while循环的目的
            System.out.println("task start");
            for(int i = 0; i < 10000; ) {
                i--;
                i+=2;
            }
            System.out.println("task end");
        }
        System.out.println("T4 finished.");
    }
}
