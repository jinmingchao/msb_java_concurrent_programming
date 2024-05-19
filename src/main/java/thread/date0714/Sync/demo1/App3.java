package thread.date0714.Sync.demo1;

import java.util.concurrent.TimeUnit;

public class App3 {

    //Todo 单个对象的synchronized (this) {}代码块成为临界区， 锁是当前对象
     void dosth(String name) {
         synchronized (this) {
             System.out.println(name + " in.");
             try {
                 TimeUnit.SECONDS.sleep(1);
             } catch (InterruptedException e) {
                 e.printStackTrace();
             }
             System.out.println(name + " out.");
         }
    }

    public static void main(String[] args) {
        App3 a = new App3();
        for(int i = 0; i < 10; i++) {
            new Thread(new T3(a),"t"+ i).start();
        }
    }
}

class T3 implements Runnable {

    App3 a;

    public T3 (App3 a) {
        this.a = a;
    }

    @Override
    public void run() {
        a.dosth(Thread.currentThread().getName());
    }
}
