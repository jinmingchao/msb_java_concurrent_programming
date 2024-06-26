package concurrent_programming.concurrent_tool.cyclicbarrier;

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
        cb.reset();//cb还可以重置，然后重新尝试拦截cnt数量的线程
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
            int a = cb.await();
            System.out.println("WorkThread " + threadName + " arrive at " + a+".");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
        System.out.println("WorkThread " + threadName + " start after cb.");
    }
}