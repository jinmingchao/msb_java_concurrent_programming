package thread.date20231108.shutdownthread;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;

public class MyThreadPoolExecutor extends ThreadPoolExecutor {

    public static ConcurrentHashMap<Runnable, Thread> executingThreads;

    public MyThreadPoolExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
        executingThreads = new ConcurrentHashMap<>();

    }

    /**
     * 钩子函数, 现在task.run()执行前调用
     * @param t the thread that will run task {@code r}
     * @param r the task that will be executed
     */
    @Override
    protected void beforeExecute(Thread t, Runnable r) {
        super.beforeExecute(t, r);
        executingThreads.put(r, t);
        System.out.println("Thread - " + t.getName()+" is added in executingThreads. Runnable hashcode() is " +r.hashCode());
    }

    /**
     *
     *
     * 钩子函数, 现在task.run()执行后调用
     * @param r the runnable that has completed
     * @param t the exception that caused termination, or null if
     * execution completed normally
     */
    @Override
    protected void afterExecute(Runnable r, Throwable t) {
        super.afterExecute(r, t);
        if (executingThreads.containsKey(r)) {
            System.out.println("Runnable - " + r.hashCode() + " has removed from executingThreads.");
            executingThreads.remove(r);
        }
    }


    /**
     * List<Runnable> runnableList= super.shutdownNow();
     * 这个返回的 runnableList里的任务，是在调用线程池的shutDownNow()之后，把没有执行的任务返回了
     * @return
     */
    @Override
    public List<Runnable> shutdownNow() {
        List<Runnable> runnableList= super.shutdownNow();
        System.out.println("shutdownNow - runnableList.size():" + runnableList.size());
//        for(Thread t : executingThreads.values()) {
//            t.interrupt();
//            System.out.println("Thread - " + t.getName()+" called interrupt();");
//        }
        return runnableList;
    }


    /**
     *
     *  位置在{@link ThreadPoolExecutor.Worker.tryTerminate}
     * 在终止线程池中，当将线程池状态置于TIDYING成功后, 在将线程池状态置于TERMINATED之前调用, 相当于线程池已经确认要被关闭了, 死前要做的操作, 做完这个操作就死了
     */
    @Override
    protected void terminated() {
        super.terminated();
    }
}
