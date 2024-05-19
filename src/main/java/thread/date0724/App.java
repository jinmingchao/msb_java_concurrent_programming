package thread.date0724;

import java.util.concurrent.TimeUnit;

public class App {

    public static volatile boolean stop = false;

    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                int i = 0;
                while (!stop) {
                    i++;
                }
                System.out.println("i: " + i);
            }
        });
        t.start();
        TimeUnit.SECONDS.sleep(5);
        stop = true;
    }
}
