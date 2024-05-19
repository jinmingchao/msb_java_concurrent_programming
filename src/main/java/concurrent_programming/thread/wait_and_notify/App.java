package concurrent_programming.thread.wait_and_notify;

/**
 * static synchronized 实际上锁的是类的Class对象，既App.class
 */
public class App {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            sync();
        }, "t1");
        Thread t2 = new Thread(() -> {
            sync();
        }, "t2");

        t1.start();
        t2.start();
        Thread.sleep(15000);
        synchronized (App.class) {
//            App.class.notify();//t1,t2随机挑一个唤醒
            App.class.notifyAll();//t1,t2都唤醒
        }
    }

    public static synchronized void sync() {
        try {
            for (int i = 0; i < 10; i++) {
                if (i == 5) {
                    App.class.wait();
                    System.out.println(Thread.currentThread().getName() + " stop waiting.");
                }
                Thread.sleep(1000);
                System.out.println(Thread.currentThread().getName());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
