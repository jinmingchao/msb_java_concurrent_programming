package msb_algorithm.test_20231117.App2;

import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;

public class StaffTask_tl_2 implements Callable<Boolean> {

    private ThreadLocal<Staff> staff_tl;

    private CountDownLatch cdl;

    public StaffTask_tl_2(ThreadLocal<Staff> staff, CountDownLatch cdl) {
        this.staff_tl = staff;
        this.cdl = cdl;
    }

    @Override
    public Boolean call() {
        try {
            Staff staff = staff_tl.get();
            String n = staff.name;
            System.out.println("StaffTask_2's staff's initial name is " + staff.name);
            staff.name = "Alice";
            System.out.println("StaffTask_2 changes the staff's name from " + n + " to " + staff.name);
            return null;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            cdl.countDown();
        }
        return null;
    }
}
