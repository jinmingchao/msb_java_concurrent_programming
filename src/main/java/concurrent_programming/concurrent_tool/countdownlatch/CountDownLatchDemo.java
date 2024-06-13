package concurrent_programming.concurrent_tool.countdownlatch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class CountDownLatchDemo {
    static ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(3);

    static CountDownLatch countDownLatch = new CountDownLatch(3);

    public static void main(String[] args) throws InterruptedException {
        System.out.println("主业务开始执行");
        sleep(1000);
        executor.execute(CountDownLatchDemo::a);
        executor.execute(CountDownLatchDemo::b);
        executor.execute(CountDownLatchDemo::c);
        System.out.println("三个任务并行执行,主业务线程等待");
        // 死等任务结束
        // countDownLatch.await();
        // 如果在规定时间内，任务没有结束，返回false
        if (countDownLatch.await(10, TimeUnit.SECONDS)) {
            System.out.println("三个任务处理完毕，主业务线程继续执行");
        }else{
            System.out.println("三个任务没有全部处理完毕，执行其他的操作");
        }
    }

    private static void a() {
        System.out.println("A任务开始");
        sleep(1000);
        System.out.println("A任务结束");
        countDownLatch.countDown();
    }
    private static void b() {
        System.out.println("B任务开始");
        sleep(1500);
        System.out.println("B任务结束");
        countDownLatch.countDown();
    }
    private static void c() {
        System.out.println("C任务开始");
        sleep(2000);
        System.out.println("C任务结束");
        countDownLatch.countDown();
    }

    private static void sleep(long timeout){
        try {
            Thread.sleep(timeout);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
