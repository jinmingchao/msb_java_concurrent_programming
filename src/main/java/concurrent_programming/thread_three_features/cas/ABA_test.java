package concurrent_programming.thread_three_features.cas;

import java.util.concurrent.atomic.AtomicStampedReference;

/**
 *  CAS操作的问题之一是会导致ABA问题
 *  解决方案是为数据引入版本号(MVCC)
 *
 *  Java中的AtomicStampedReference就是这种方案的实现
 *
 */
public class ABA_test {
    public static void main(String[] args) {
        //设置变量初始值为AAA，版本为1
        AtomicStampedReference<String> reference = new AtomicStampedReference<>("AAA",1);

        //获取当前内存中的旧值和旧版本
        String oldVal = reference.getReference();
        int oldVersion = reference.getStamp();
        System.out.println("oldVal:" + oldVal);
        System.out.println("oldVersion:" + oldVersion);
        //尝试进行CAS操作: 提供参数: (旧值, 新值, 旧版本, 新版本)
        boolean b1 = reference.compareAndSet(oldVal,"B",oldVersion,oldVersion + 1); //这句成功, 因为旧版本正确
        boolean b2 = reference.compareAndSet("B","C",oldVersion ,oldVersion + 1); //这句失败, 因为旧版本错误, 版本应该是2了
        System.out.println("b1: " + b1+", b2: " + b2);



    }
}
