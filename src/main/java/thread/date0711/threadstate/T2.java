package thread.date0711.threadstate;

import java.util.Queue;

public class T2 implements Runnable{

    Queue<Thread> q;

    public T2 (Queue<Thread> q){
        this.q = q;
    }

    @Override
    public void run() {
        int i = 40;
        while (i >= 0) {
           Thread t = q.poll();
           System.out.println(t.getName()+ " states: " + t.getState());
           q.offer(t);
           i--;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        if(q.poll().getState() == Thread.State.WAITING){
            System.out.println("Join test");
            q.poll().interrupt();
            synchronized (Main.lock) {
                Main.lock.notifyAll();
            }
        }

//        if(q.poll().getState() == Thread.State.WAITING){
//            synchronized (Main.lock) {
//                Main.lock.notifyAll();
//            }
//        }
    }
}
