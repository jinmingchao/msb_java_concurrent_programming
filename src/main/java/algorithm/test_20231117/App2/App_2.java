package algorithm.test_20231117.App2;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class App_2 {

    private static ThreadLocal<Staff> tl_staff;

    public void App() throws InterruptedException {
        StaffThreadPool pool = new StaffThreadPool(5, 8, 10, TimeUnit.SECONDS, new LinkedBlockingQueue<>(10), new ThreadPoolExecutor.DiscardPolicy());
        Staff staff = new Staff();

        tl_staff = new ThreadLocal<Staff>() {
            @Override
            protected Staff initialValue() {
                return new Staff();
            }
        };

//        tl_staff = new ThreadLocal<>();
        //tl_staff.set(staff);

        CountDownLatch cdl = new CountDownLatch(3);


//        pool.submit(staffTask_1);
//        pool.submit(staffTask_2);
//        pool.submit(staffTask_3);

        for (int i = 3; i > 0; i--) {
            if (i == 3) {
                StaffTask_tl_1 staffTask_1 = new StaffTask_tl_1(tl_staff, cdl);
                pool.submit(staffTask_1);
            }
            if (i == 2) {
                StaffTask_tl_2 staffTask_2 = new StaffTask_tl_2(tl_staff, cdl);
                pool.submit(staffTask_2);
            }
            if (i == 1) {
                StaffTask_tl_3 staffTask_3 = new StaffTask_tl_3(tl_staff, cdl);
                pool.submit(staffTask_3);
            }
            Thread.sleep(2000L);
        }
        cdl.await();
        System.out.println("main thread staff's name is " + staff.name);
        pool.shutdown();
    }

    public static void main(String[] args) throws InterruptedException {
        new App_2().App();
    }
}
