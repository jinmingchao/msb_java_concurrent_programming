package algorithm.test_20231117.App2;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ThreadLocalDemo_1 {


    // SimpleDateFormat is not thread-safe, so give one to each thread
    private static final ThreadLocal<SimpleDateFormat> formatter = new ThreadLocal<SimpleDateFormat>() {
        @Override
        protected SimpleDateFormat initialValue() {
            return new SimpleDateFormat("yyyyMMdd HHmm");
        }
    };

    public String formatIt(Date date) {
        return formatter.get().format(date);
    }

}
