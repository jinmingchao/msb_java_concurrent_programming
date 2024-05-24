package concurrent_programming.reentrantlock_all.reentrantReadWriteLock;

import java.util.concurrent.locks.ReentrantReadWriteLock;


/**
 *
 * 读锁测试
 *
 * 只有读锁的时候, 锁是共享的，多个线程的读操作是可以并发的
 */
public class App_1 {

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

            readLock.lock();
            Thread.sleep(1000);
            System.out.println("主线程拿到锁.");
            readLock.unlock();

    }
}
