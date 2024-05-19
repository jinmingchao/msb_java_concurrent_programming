package thread.date0714.Sync.demo1;

import java.util.concurrent.TimeUnit;

public class App1 {

    String name;

    public App1(String name) {
        this.name = name;
    }

    //Todo App1类的dosth成为临界区，即App1中所有实例的dosth方法共享同一临界区
    //todo 实际上上锁的是APP1.class这个对象
    synchronized static void dosth(String name) {
        System.out.println(name + " in.");
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(name + " out.");
    }

    public static void main(String[] args) {
        for(int i = 0; i < 10; i++) {
            new Thread(new T1(new App1("a" +i))).start();
        }
    }

    @Override
    public String toString() {
        return "App{" +
                "name='" + name + '\'' +
                '}';
    }
}

class T1 implements Runnable {

    App1 a;

    public T1 (App1 a) {
        this.a = a;
    }

    @Override
    public void run() {
        App1.dosth(a.name);
//        a.dosth(a.name);
    }
}

