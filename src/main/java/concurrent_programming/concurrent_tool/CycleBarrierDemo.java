package concurrent_programming.concurrent_tool;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CycleBarrierDemo {
    public static void main(String[] args) throws Exception {
        int cnt = 10;
        CyclicBarrier cb = new CyclicBarrier(cnt,()->{
            System.out.println("CB执行完毕...");
        });
        for (int i = 0; i < cnt; i++) {
            new Thread(new WorkThread(cb, String.valueOf(i))).start();
        }
    }

}

class WorkThread implements Runnable {

    private CyclicBarrier cb;
    private String threadName;

    public WorkThread(CyclicBarrier cb, String threadName) {
        this.cb = cb;
        this.threadName = threadName;
    }

    @Override
    public void run() {
        int time = 1 + new Random().nextInt(10);
        System.out.println("WorkThread " + threadName + " start sleeping for " + time + " seconds.");
        try {

            Thread.sleep(time * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            System.out.println("WorkThread " + threadName + " wake up.");
            cb.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
        System.out.println("WorkThread " + threadName + " start after cb.");
    }
}