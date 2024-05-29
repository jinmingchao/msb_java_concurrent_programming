package concurrent_programming.thread_pool;

import java.util.concurrent.*;

//手动构建线程池
public class App_1 {

    /**
     * {@link ThreadPoolExecutor.CallerRunsPolicy}
     * {@link concurrent_programming.lock.locjkupgrade.App_2}
     * @param args
     */
    public static void main(String[] args) {
        //1. 构建线程池
        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(
                2,
                5,
                10,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(5),
                new ThreadFactory() {
                    @Override
                    public Thread newThread(Runnable r) { // r的意思是进入线程池的任务
                        Thread thread = new Thread(r);
                        thread.setName("test-ThreadPoolExecutor");
                        return thread;
                    }
                },
                new MyRejectedExecution()
        );
        threadPool.allowCoreThreadTimeOut(true); //允许核心线程池过期
        //2. 让线程池处理任务,没返回结果
        threadPool.execute(() -> {
            System.out.println("没有返回结果的任务");
        });

        //3. 让线程池处理有返回结果的任务
        Future<Object> future = threadPool.submit(new Callable<Object>() {
            @Override
            public Object call() throws Exception {
                System.out.println("我有返回结果！");
                return "返回结果";
            }
        });
        Object result = null;
        try {
            result = future.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println(result);

        //4. 如果是局部变量的线程池，记得用完要shutdown
        threadPool.shutdown();
    }

    private static class MyRejectedExecution implements RejectedExecutionHandler {
        @Override
        public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
            System.out.println("根据自己的业务情况，决定编写的代码！");
        }
    }
}


