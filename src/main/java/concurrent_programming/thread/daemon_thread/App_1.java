package concurrent_programming.thread.daemon_thread;

public class App_1 {
    public static void main(String[] args) {
        Thread t1 = new Thread(()->{
            for (int i = 0; i < 10; i++) {
                System.out.println("t1:" + i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t1.setDaemon(true); //因为t1是守护线程，没有非守护线程的时候，主线程会被jvm停止，所以就无法执行t1的遍历打印了
        t1.start();
        System.out.println("main 执行结束..");
    }
}
