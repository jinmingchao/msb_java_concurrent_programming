package concurrent_programming.thread_three_features.cas;

import java.util.concurrent.atomic.AtomicInteger;

/**
 *  Java提供的AtomicXXX类，底层就是通过CAS来实现值的比较和设置的
 *
 *  但是普通的atomicInteger会有一些问题:
 *  1、会有ABA的问题
 *  2、会有自旋过长的问题
 */
public class App_1 {
    public static void main(String[] args) {
        AtomicInteger i = new AtomicInteger(2);
        int res = i.incrementAndGet();
        System.out.println(res);
    }
}
