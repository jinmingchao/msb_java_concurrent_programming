package thread.date0714.Sync.demo1;

import java.util.concurrent.TimeUnit;

public class App2 {

    //Todo 单个对象的dosth方法成为临界区, 其实用的锁就是这个对象
    //TODO 适用场景是当很多线程都获取这个对象的时候，大家一起调用某一个方法，这个方法会成为临界区
    synchronized void dosth(String name) {
        System.out.println(name + " in.");
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(name + " out.");
    }

    public static void main(String[] args) {
        App2 a = new App2();

//        a.dosth("1");
//        a.dosth("3");
//        a.dosth("5");

        for(int i = 0; i < 10; i++) {
            new Thread(new T2(a),"t"+ i).start();
        }
    }
}

class T2 implements Runnable {

    App2 a;

    public T2 (App2 a) {
        this.a = a;
    }

    @Override
    public void run() {
        a.dosth(Thread.currentThread().getName());
    }
}
