package concurrent_programming.reentrantlock_all.condition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

public class App_1 {

    static ReentrantLock lock = new ReentrantLock();
    static Condition condition;

    public static void main(String[] args) throws InterruptedException {
        LockSupport.park();
        condition = lock.newCondition();
        new Thread(()->{
            lock.lock();
            System.out.println("子线程获取锁并await挂起锁");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            try {
                condition.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(lock.isHeldByCurrentThread())
            System.out.println("子线程被唤醒, 并持有锁资源.");
        }).start();

        Thread.sleep(500);
        lock.lock();
        System.out.println("主线程等待5s拿到锁, 子线程执行了await方法.");
        condition.signal();
        System.out.println("主线程调用signal()方法.");
        Thread.sleep(2000);
        System.out.println("主线程休眠2S, 然后释放锁.");
        lock.unlock();
    }
}
