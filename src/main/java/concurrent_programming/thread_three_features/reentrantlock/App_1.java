package concurrent_programming.thread_three_features.reentrantlock;

import java.util.concurrent.locks.ReentrantLock;

/**
 *
 *  重量级锁，在高并发场景下，相比于synchronized关键字或者Lock类
 *  更推荐使用ReentrantLock
 *
 *
 */
public class App_1 {
    private static ReentrantLock lock = new ReentrantLock();
    private static int cnt = 0;
    public static void increment() {
        lock.lock();
        try {
            cnt++;
        } finally {
            lock.unlock(); //ReentrantLock没有异常退出机制，所以添加finally代码块，在遇到异常时强制退出
        }

    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(()->{
            for (int i = 0; i < 100; i++) {
                    increment();
            }
        });

        Thread t2 = new Thread(()->{
            for (int i = 0; i < 100; i++) {
                increment();
            }
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("cnt: " + cnt);
    }



}
