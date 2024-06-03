package concurrent_programming.concurrent_collection.blockqueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

public class App_ArrayBlockQueue {
    public static void main(String[] args) throws InterruptedException {
        ArrayBlockingQueue queue = new ArrayBlockingQueue(3); //底层数组实现，所以要传入capacity
        queue.add(1);
        queue.add(2);
        //fifo
        System.out.println(queue.remove());
        System.out.println(queue.remove());


        //常用操作
        // 生产者扔数据
        queue.add("1");
        queue.offer("2");
        queue.offer("3",2, TimeUnit.SECONDS);
        queue.put("2");

        // 消费者取数据
        System.out.println(queue.remove());
        System.out.println(queue.poll());
        System.out.println(queue.poll(2,TimeUnit.SECONDS));
        System.out.println(queue.take());
    }
}
