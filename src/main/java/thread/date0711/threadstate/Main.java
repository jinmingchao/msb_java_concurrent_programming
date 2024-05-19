package thread.date0711.threadstate;

import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public  static  Object lock = new Object();

    public static void main(String[] args) {
        Queue<Thread> q = new LinkedList<>();
        Thread t1 = new Thread(new T1(),"T1");
        q.offer(t1);
        Thread t2 = new Thread(new T2(q),"T2");
        t1.start();
        t2.start();
    }
}
