package concurrent_programming.thread_three_features.cas;

import java.util.concurrent.atomic.LongAdder;

/**
 *  对于AtomicXXX自旋时间过长导致占用CPU过多的优化方式
 *
 *  1. 可以指定CAS循环的次数, 如果超过这个次数，就直接失败/挂起线程
 *  2. 将变化操作暂存，当要获取最终结果时， 等到其他线程执行完以后，再把变化执行，最终返回结果？
 *     具体实现就是LongAdder(TODO： 自己看下LongAdder源码)
 */
public class App_2 {
    public static void main(String[] args) {
        LongAdder cnt;
    }
}
