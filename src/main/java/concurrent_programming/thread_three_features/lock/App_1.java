package concurrent_programming.thread_three_features.lock;

import java.util.concurrent.locks.ReentrantLock;

public class App_1 {
    static ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) {
            lock.lock();
    }
}
