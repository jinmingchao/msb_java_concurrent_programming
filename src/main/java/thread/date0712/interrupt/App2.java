package thread.date0712.interrupt;

import java.util.concurrent.TimeUnit;

public class App2 {
    public static void main(String[] args) {
        Thread t2 = new Thread(new T2());
        t2.start();
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("打断");
        t2.interrupt(); // set t1.isInterrupted() = true;
    }
}

class T2 implements Runnable {

    @Override
    public void run() {

        while (true) {
            if(Thread.currentThread().isInterrupted()) {
                System.out.println("before: " + Thread.currentThread().isInterrupted()); //T2已经被T1打断过了, 所以返回isInterrupted() 返回 true
                System.out.println(Thread.interrupted()); // 在这里 T2 成功的把 isInterrupted() 的返回值 置成false, 即未被打断的状态, 所以返回值是true。
                System.out.println(Thread.interrupted()); // 因为 T2 之前已经把 isInterrupted()置成false, 所以这里返回false
                System.out.println("after: " + Thread.currentThread().isInterrupted()); //因为重置过了，所以isInterrupted() 又返回false
            }
        }
    }
}
