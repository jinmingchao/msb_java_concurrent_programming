package algorithm.test_20231117.App2;

import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;

public class StaffTask_1 implements Callable<Boolean> {

    private Staff staff;

    private CountDownLatch cdl;

    public StaffTask_1(Staff staff, CountDownLatch cdl) {
        this.staff = staff;
        this.cdl = cdl;
    }

    @Override
    public Boolean call() throws Exception {
        String n = staff.name;
        System.out.println("StaffTask_1's staff's initial name is " + staff.name);
        staff.name = "Bob";
        System.out.println("StaffTask_1 changes the staff's name from " + n + " to " + staff.name);
        cdl.countDown();
        return null;
    }
}
