package thread.date0712.join;

import java.util.Deque;
import java.util.LinkedList;

public class Main {

    static Deque<Thread> q = new LinkedList<>();

    public static void main(String[] args) throws InterruptedException {
        int n = 1;
        for (;n <= 10;) {
            if((n & 1) == 1) {
                q.offerLast(new Thread(new T21(q.isEmpty() ? null : q.peekLast()),"T" + n));
            } else if((n & 1) == 0){
                q.offerLast(new Thread(new T22(q.isEmpty() ? null : q.peekLast()),"T" + n));
            }
            ++n;
        }

        while (!q.isEmpty()) {
            q.pollFirst().start();
        }
    }
}

class T21 extends Thread {

    Thread preThread;

    public T21 (Thread preThread) {
        this.preThread = preThread;
    }

    @Override
    public void run() {
        if(null != preThread) {
            try {
//                System.out.println(Thread.currentThread().getName() + " is waiting");
                preThread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName() + " is running" );
        //do something

    }
}

class T22 extends Thread {

    Thread preThread;

    public T22 (Thread preThread) {
        this.preThread = preThread;
    }

    @Override
    public void run() {
        if(null != preThread) {
            try {
//                System.out.println(Thread.currentThread().getName() + " is waiting");
                preThread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName() + " is running" );
        //do something
    }
}