package thread.date20231108.shutdownthread;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class MyTask implements Callable {

    private Integer time;
    private String name;

    public MyTask(String name, Integer time) {
        this.name = name;
        this.time = time;
    }

    @Override
    public Object call() throws Exception {
        System.out.println("task - " + Thread.currentThread().getName() + " start.");
//        while (true);
        //1.
//        Integer i = 0;
//        while (true) {
//            //TODO 如果知识单纯的执行死循环就无法退出
////            System.out.println("task - " + Thread.currentThread().getName() +" is running.");
//            //TODO 如果调用sleep(); 就能正确退出了
//            i++;
//            if(i == (1 << 8) ) {
//                System.out.println("task - " + Thread.currentThread().getName() +" call sleep().");
//                Thread.sleep(30000L);
//            }
//        }
        //2.yield没用
//        Integer i = 0;
//        while (true) {
//            //TODO 如果知识单纯的执行死循环就无法退出
////            System.out.println("task - " + Thread.currentThread().getName() +" is running.");
//            //TODO 如果调用sleep(); 就能正确退出了
//            i++;
//            if(i == (1 << 8) ) {
//                System.out.println("task - " + Thread.currentThread().getName() +" call yield().");
//                Thread.yield();
//            }
//        }
        //3.Thread.isInterrupt()
        Integer i = 0;
        while (true) {
            //TODO 如果知识单纯的执行死循环就无法退出
//            System.out.println("task - " + Thread.currentThread().getName() +" is running.");
            //TODO 如果调用sleep(); 就能正确退出了
            i++;
            if(i == (1 << 12) ) {
                System.out.println("task - " + Thread.currentThread().getName() +" call interrupted().");
                if (Thread.interrupted()) {
                    Thread.currentThread().interrupt();
                    System.out.println("task - " + Thread.currentThread().getName() +" call interrupt().");
                    TimeUnit.SECONDS.sleep(1000L);
                }
            }
        }
        //4.
//        Long a = 0L;
//        for(int i = 0;i < 300000; ++i) {
//        System.out.println("task - " + Thread.currentThread().getName() +" is running.");
//            a += i;
//            a -= i;
//        }
//        return null;
    }


}
