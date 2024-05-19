package concurrent_programming.reentrantlock_all;

import java.util.concurrent.locks.ReentrantLock;

public class App_1 {

    static ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) throws InterruptedException {
           new Thread(()->{
               try {
                   Thread.sleep(6000);
               } catch (InterruptedException e) {
                   throw new RuntimeException(e);
               }
               System.out.println("t1线程尝试获取锁。");
           }).start();
           lock.lock();
           System.out.println("主线程获取锁，开始休眠.");
           Thread.sleep(50000);
           lock.unlock();


    }
}
