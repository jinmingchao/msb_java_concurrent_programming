package thread.date20231108.shutdownthread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class App1 {
    public static void main(String[] args) {
        ExecutorService es = Executors.newFixedThreadPool(10);
        es.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread start.");
                try {
                    Thread.sleep(30000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Thread end.");
            }
        });//执行子线程任务
        try {
            es.shutdown();
            if (!es.awaitTermination(10, TimeUnit.SECONDS)) {//10S
                System.out.println(" 到达指定时间，还有线程没执行完，不再等待，关闭线程池!");
                es.shutdownNow();
            }
        } catch (Throwable e) {
            // TODO Auto-generated catch block
            es.shutdownNow();
            e.printStackTrace();
        }
    }
}
