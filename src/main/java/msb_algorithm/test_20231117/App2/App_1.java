package msb_algorithm.test_20231117.App2;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class App_1 {

    public static void main(String[] args) throws InterruptedException {

        StaffThreadPool pool = new StaffThreadPool(5, 8, 10, TimeUnit.SECONDS, new LinkedBlockingQueue<>(10), new ThreadPoolExecutor.DiscardPolicy());
        Staff staff = new Staff();
        CountDownLatch cdl = new CountDownLatch(3);
        StaffTask_1 staffTask_1 = new StaffTask_1(staff, cdl);
        StaffTask_2 staffTask_2 = new StaffTask_2(staff, cdl);
        StaffTask_3 staffTask_3 = new StaffTask_3(staff, cdl);
//        pool.submit(staffTask_1);
//        pool.submit(staffTask_2);
//        pool.submit(staffTask_3);

        for (int i = 3; i > 0; i--) {
            if (i == 3)
                pool.submit(staffTask_1);
            if (i == 2)
                pool.submit(staffTask_2);
            if (i == 1)
                pool.submit(staffTask_3);
            Thread.sleep(3000L);
        }
        cdl.await();
        System.out.println("main thread staff's name is " + staff.name);
        pool.shutdown();
    }
}
