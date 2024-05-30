package concurrent_programming.thread_pool;

public class App_2 {
    public static void main(String[] args) {
        int a = 10928;
        System.out.println(~a + 1);

        int ctl = 0;
        int COUNT_BITS = Integer.SIZE - 3;
        int RUNNABLE = -1 << COUNT_BITS;
        ctl = RUNNABLE | 0;
        System.out.println("ctl: " + ctl);
        

    }
}
