package msb_algorithm.test_20231120.App1;

import java.util.concurrent.Callable;

public class StaffTask implements Callable<Boolean> {

    Staff staff;

    public StaffTask(Staff staff) {
        this.staff = staff;
    }

    @Override
    public Boolean call() throws Exception {
        System.out.println("Read Staff, StaffNum is " + staff.StaffNum);
        return null;
    }
}
