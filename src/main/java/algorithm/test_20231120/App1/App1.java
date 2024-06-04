package algorithm.test_20231120.App1;

import java.util.concurrent.*;

public class App1 {

    private static ConcurrentLinkedQueue<Staff> queue = new ConcurrentLinkedQueue();

    public static void main(String[] args) {

        new Thread(() -> {
            int i = 1 ;
            Staff staff;
            for (;;) {
                staff = new Staff(i);
                System.out.println("Add Staff, StaffNum is " + i);
                queue.offer(staff);
                i++;
//                try {
//                    Thread.sleep(3000L);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
            }
        }).start();

        ThreadPoolExecutor pool = new ThreadPoolExecutor(2, 2, 5, TimeUnit.SECONDS, new LinkedBlockingQueue<>(10), new ThreadPoolExecutor.CallerRunsPolicy());

        while (true) {
           Staff staff = queue.poll();
           if(staff != null) {
               StaffTask staffTask = new StaffTask(staff);
               pool.submit(staffTask);
           }
        }
    }
}
