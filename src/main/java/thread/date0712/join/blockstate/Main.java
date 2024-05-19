package thread.date0712.join.blockstate;

import java.util.concurrent.TimeUnit;

public class Main {

    public static Object lock = new Object();

    public static void main(String[] args) {

        Thread t0 = new Thread(new T0(),"T0");

        Thread t1 = new Thread(new T1(t0),"T1");
        Thread t2 = new Thread(new T2(t0),"T2");

        Thread t3 = new Thread(new T3(t1),"T3");

        t3.start();
        t2.start();
        t1.start();

        

    }
}


class T0 implements Runnable {

    @Override
    public void run() {
        //signal thread.
    }
}

class T1 implements Runnable {
    Thread signalThread;

    public T1(Thread signalThread){
        this.signalThread = signalThread;
    }

    @Override
    public void run() {
        //Ensure the T1 gets the lock before than the T2.
        try {
            signalThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //Blocked at sync statement.
        System.out.println("T1 tries to get the lock");
        synchronized (Main.lock) {
            //should cannot reach this statement.
            System.out.println("T1 gets the lock.");
        }
    }
}

class T2 implements Runnable {

    Thread signalThread;

    public T2 (Thread signalThread) {
        this.signalThread = signalThread;
    }

    @Override
    public void run() {
        synchronized (Main.lock) {
            try {
                // Ensure the T2 gets the lock before than T1.
                signalThread.start();

                TimeUnit.SECONDS.sleep(1000); // will not release the lock
//                Main.lock.wait(1000); // will release the lock
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}


class T3 implements Runnable {
    public Thread t1;

    public T3 (Thread t1) {
        this.t1 = t1;
    }

    //watch the state of T1
    @Override
    public void run() {
        while (true) {
            System.out.println("T1's state is " + t1.getState());
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}