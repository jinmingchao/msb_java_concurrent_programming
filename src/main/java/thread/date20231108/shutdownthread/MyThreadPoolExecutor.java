package thread.date20231108.shutdownthread;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class MyThreadPoolExecutor extends ThreadPoolExecutor {

    public static ConcurrentHashMap<Runnable, Thread> executingThreads;

    public MyThreadPoolExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
        executingThreads = new ConcurrentHashMap<>();

    }

    @Override
    protected void beforeExecute(Thread t, Runnable r) {
        super.beforeExecute(t, r);
        executingThreads.put(r, t);
        System.out.println("Thread - " + t.getName()+" is added in executingThreads. Runnable hashcode() is " +r.hashCode());
    }

    @Override
    protected void afterExecute(Runnable r, Throwable t) {
        super.afterExecute(r, t);
        if (executingThreads.containsKey(r)) {
            System.out.println("Runnable - " + r.hashCode() + " has removed from executingThreads.");
            executingThreads.remove(r);
        }
    }

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
}
