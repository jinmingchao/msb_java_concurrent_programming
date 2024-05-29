package concurrent_programming.concurrent_tool.sync_queue;

import java.util.concurrent.SynchronousQueue;

public class App_1 {
    public static void main(String[] args) {
        SynchronousQueue<Integer> q = new SynchronousQueue<>();
        q.offer(1);
        q.poll();
        Long i = 10213L;
        System.out.println(String.format("%08d",i));
    }
}
