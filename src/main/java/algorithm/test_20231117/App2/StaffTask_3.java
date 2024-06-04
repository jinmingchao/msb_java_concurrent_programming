package algorithm.test_20231117.App2;

import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;

public class StaffTask_3 implements Callable<Boolean> {


    private CountDownLatch cdl;

    private Staff staff;

    public StaffTask_3(Staff staff, CountDownLatch cdl) {
        this.staff = staff;
        this.cdl = cdl;
    }

    @Override
    public Boolean call() throws Exception {
        String n = staff.name;
        System.out.println("StaffTask_3's staff's initial name is " + staff.name);
        staff.name = "Andy";
        System.out.println("StaffTask_3 changes the staff's name from " + n + " to " + staff.name);
        cdl.countDown();
        return null;
    }
}
