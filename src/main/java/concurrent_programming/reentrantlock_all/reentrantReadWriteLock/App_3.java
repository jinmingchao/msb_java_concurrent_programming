package concurrent_programming.reentrantlock_all.reentrantReadWriteLock;

import java.util.concurrent.locks.ReentrantReadWriteLock;


/**
 *
 * 读写锁同时使用测试
 *
 * 读锁和写锁共用时, 锁是互斥的, 即读锁写锁共享一个临界区
 */
public class App_3 {

    static ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    static ReentrantReadWriteLock.WriteLock writeLock = lock.writeLock();

    static ReentrantReadWriteLock.ReadLock readLock = lock.readLock();

    public static void main(String[] args) throws InterruptedException {
            new Thread(()-> {
                readLock.lock();
                System.out.println("子线程拿到锁.");
                try {
                    Thread.sleep(50000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    readLock.unlock();
                }
            }).start();

        Thread.sleep(2000);
        System.out.println("主线程尝试拿锁.");
        writeLock.lock();
        System.out.println("主线程拿到锁.");
        writeLock.unlock();

    }
}
