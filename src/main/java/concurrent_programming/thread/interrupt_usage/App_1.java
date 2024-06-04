package concurrent_programming.thread.interrupt_usage;

/**
 * 停止线程的方式:
 * 1. 调用stop()，已经弃用，不够优雅
 * 2. 共享变量 while(isDone) {......} , 然后外部通过修改isDone的值来结束Thread
 * 3. interrupt()方法
 * 4. 通过打断状态是waiting或timed_waiting状态的线程, 从而抛出异常自行处理
 *
 * 注意， interrupt()方法，打断不了处于BLOCK状态的线程
 */
public class App_1 {
    public static void main(String[] args) throws InterruptedException {
        // 线程默认情况下, interrupt 标记位: false;
        System.out.println("1:" + Thread.currentThread().isInterrupted());
        // 执行interrupt打断线程
        Thread.currentThread().interrupt();
        // 再次查看标志位, 由于被打断, interrupt标志位改为: true
        System.out.println("2:" + Thread.currentThread().isInterrupted());
        // 归位interrupt标记 为 false, 返回true，说明归位成功
        System.out.println("3:" + Thread.interrupted());
        // 再次尝试归位，由于已经归位过并且没有再被打断，所以返回false
        System.out.println("4:" + Thread.interrupted());
        // 再次查看标志位，由于已经被归位，所以返回false
        System.out.println("5:" + Thread.currentThread().isInterrupted());


        //============================================
        // 第三种方法测试
        Thread t1 = new Thread(()->{
            while (!Thread.currentThread().isInterrupted()) {
                // 处理业务
            }
            System.out.println("t1结束.");
        });
        t1.start();
        Thread.sleep(1000);
        t1.interrupt();
    }
}
