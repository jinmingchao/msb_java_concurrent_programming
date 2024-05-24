package concurrent_programming.reentrantlock_all.reentrantReadWriteLock;

import java.util.concurrent.locks.ReentrantReadWriteLock;


/**
 *
 * 写锁测试
 *
 * 只有写锁时，锁是互斥锁，类似正常的reentrantlock
 */
public class App_2 {

    static ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    static ReentrantReadWriteLock.WriteLock writeLock = lock.writeLock();

    static ReentrantReadWriteLock.ReadLock readLock = lock.readLock();

    public static void main(String[] args) throws InterruptedException {
            new Thread(()-> {
                writeLock.lock();
                System.out.println("子线程拿到锁.");
                try {
                    Thread.sleep(500000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    writeLock.unlock();
                }
            }).start();

        Thread.sleep(2000);
        System.out.println("主线程尝试拿锁.");
        writeLock.lock();
            System.out.println("主线程拿到锁.");
        writeLock.unlock();

    }
}
