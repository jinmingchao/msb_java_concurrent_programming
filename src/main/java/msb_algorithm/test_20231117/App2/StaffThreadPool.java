package msb_algorithm.test_20231117.App2;

import java.util.concurrent.*;

public class StaffThreadPool extends ThreadPoolExecutor {

    public StaffThreadPool(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue, RejectedExecutionHandler handler) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, handler);
    }
}
