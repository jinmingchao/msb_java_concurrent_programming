package msb_algorithm.test_20231117.App2;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class App_3 {
    public static void main(String[] args) {

        //1.CallerRunsPolicy(), 任务多了主线程继续执行
        ThreadPoolExecutor tpe = new ThreadPoolExecutor(4, 6, 10, TimeUnit.SECONDS, new LinkedBlockingQueue<>(5), new ThreadPoolExecutor.CallerRunsPolicy());
        for (int i = 0; i < 100; i++) {
            tpe.submit(new Runnable() {
                @Override
                public void run() {
                    Integer id = ThreadId.get();
                    System.out.println("ThreadId is " + id);
                }
            });
        }

    }


}

