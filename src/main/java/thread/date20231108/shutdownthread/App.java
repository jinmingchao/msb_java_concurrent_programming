package thread.date20231108.shutdownthread;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.*;

public class App {
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<Runnable> workQueue = new LinkedBlockingQueue<>();
        MyThreadPoolExecutor executor = new MyThreadPoolExecutor(3, 3, 20, TimeUnit.SECONDS, workQueue);
        MyTask task_1 = new MyTask("task_1", 5), task_2 = new MyTask("task_2", 10), task_3 = new MyTask("task_3", 15);
        FutureTask<Integer> f_task_1 = new FutureTask(task_1), f_task_2 = new FutureTask(task_2), f_task_3 = new FutureTask(task_3);

        executor.submit(f_task_1);
        executor.submit(f_task_2);
        executor.submit(f_task_3);


        Thread.sleep(2000);

        //1. shutDownNow();
        List<Runnable> r = executor.shutdownNow();
        System.out.println("main thread call shutdownNow().");
        //2. shutDownNow();
//        executor.shutdown();
//        System.out.println("main thread call shutdown().");
        //3. stop tasks via threads map.
//        System.out.println("Thread.State.TERMINATED.ordinal(): " + Thread.State.TERMINATED.ordinal());
//        System.out.println("Thread.State.RUNNABLE.ordinal(): " + Thread.State.RUNNABLE.ordinal());
//        Map<Runnable, Thread> threads = MyThreadPoolExecutor.executingThreads;
//
//        while (0 != threads.size()) {
//            for (Thread thread : threads.values()) {
//                if (!thread.isInterrupted()) {
//                    thread.interrupt();
//                    System.out.println("thread - " + thread.getName() + " call interrupt().");
//                }
//
//                if (!thread.isAlive()) {
//                    System.out.println("thread - " + thread.getName() + " is dead.");
//                    threads.remove(thread);
//                } else if (thread.isAlive()) {
//                    System.out.println("thread - " + thread.getName() + " call interrupt().");
//                }
//
//
//                if (thread.getState().compareTo(Thread.State.TERMINATED) == 0) {
//                    System.out.println("thread - " + thread.getName() + " has terminated.");
//                    threads.remove(thread);
//                } else if (thread.getState().compareTo(Thread.State.RUNNABLE) == 0) {
//                    System.out.println("thread - " + thread.getName() + " still running.");
//                } else {
//                    System.out.println("thread - " + thread.getName() + " state is: " + thread.getState().name());
//                }
//            }
//        }



//        System.out.println("1.executor.isShutdown(): " + executor.isShutdown());
//        executor.shutdown();
//        System.out.println("2.executor.isShutdown(): " + executor.isShutdown());


//        while (true){
        //TODO 都干嘛用的?
//            Thread.activeCount()
//            Thread.enumerate()
//            Thread.getAllStackTraces() ....


//        }
    }
}
