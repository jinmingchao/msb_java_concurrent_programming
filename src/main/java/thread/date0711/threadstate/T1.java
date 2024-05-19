package thread.date0711.threadstate;

import java.util.concurrent.TimeUnit;

public class T1 implements Runnable{

    @Override
    public void run() {
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        int i = 20;
        while (i >= 0) {
            if(i < 10) {
                try {
                    Thread.currentThread().join();
//                    synchronized (Main.lock) {
//                        Main.lock.wait();
//                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("i:" + i);
//            try {
//                TimeUnit.SECONDS.sleep(1);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            int sum = 0;
            for(int n = 10000; n >= 0 ; n--){
                if(n <= 4000 && n >= 2000) {
                    try {
                        TimeUnit.MILLISECONDS.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                sum += n;
            }
            System.out.println("T1's own state: " + Thread.currentThread().getState());
            --i;
        }
    }
}
