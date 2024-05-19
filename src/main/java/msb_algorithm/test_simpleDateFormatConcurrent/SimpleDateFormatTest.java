package msb_algorithm.test_simpleDateFormatConcurrent;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.concurrent.atomic.AtomicBoolean;

public class SimpleDateFormatTest {
    private static final AtomicBoolean STOP  = new AtomicBoolean();
    private static final SimpleDateFormat FORMATTER = new SimpleDateFormat("yyyy/mm/dd"); //非线程安全

    public static void main(String[] args) {
        Runnable runnable = () -> {
            int count = 0;
            while (!STOP.get()) {
                try {
                    FORMATTER.parse("2023/07/15");
                } catch (ParseException e) {
                    e.printStackTrace();
                    if (++count > 3) {
                       STOP.set(true);
                    }
                }
            }
        };

        new Thread(runnable).start();
        new Thread(runnable).start();
    }
}
