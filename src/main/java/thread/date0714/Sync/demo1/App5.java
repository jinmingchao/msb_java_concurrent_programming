package thread.date0714.Sync.demo1;

import java.util.concurrent.TimeUnit;

/**
 * todo 注意，a1对象的dothing1和dothing2共享一把锁,a2对象的dothing1和dothing2共享一把锁，这两把锁是不同的两把
 * 换句话说 锁的是a1对象和a2对象
 */
public class App5 {

    public synchronized void dothing1(String name) {
        System.out.println(name + " in dothing1.");
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(name + " out dothing1.");
    }

    public synchronized void dothing2(String name) {
        System.out.println(name + " in dothing2.");
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(name + " out dothing2.");
    }

    public static void main(String[] args) {
        App5 a1 = new App5(), a2 = new App5();
        for (int i = 0; i < 10; i++) {
            if ((i & 1) == 1) {
                new Thread(new MyRunnable1(a1), "t" + i).start();
            } else {
//                new Thread(new MyRunnable2(a2), "t" + i).start();
                new Thread(new MyRunnable1(a2), "t" + i).start();
            }
        }


    }

}

class MyRunnable1 implements Runnable {

    App5 a;

    public MyRunnable1(App5 a) {
        this.a = a;
    }

    @Override
    public void run() {
        a.dothing1(Thread.currentThread().getName());
    }
}

class MyRunnable2 implements Runnable {

    App5 a;

    public MyRunnable2(App5 a) {
        this.a = a;
    }

    @Override
    public void run() {
        a.dothing2(Thread.currentThread().getName());
    }
}