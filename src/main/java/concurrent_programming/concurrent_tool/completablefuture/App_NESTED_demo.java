package concurrent_programming.concurrent_tool.completablefuture;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;

/**
 *
 *   CompletableFuture嵌套执行实例
 *
 *
 *   Task A  ------>  A.stack
 *                   --------
 *
 *
 *
 *
 *
 *                    Task B     ------>     B.stack
 *                                          ---------
 *                                          | Task D |
 *                                          ---------
 *                                          | Task E |
 *                                          ---------
 *                   --------
 *
 *
 *
 *
 *                    Task C      ------>    C.stack
 *                                          ----------
 *                                          | Task F |
 *                                          ----------
 *
 *                   --------
 *
 *
 *
 *                   执行顺序是 A -> B - D -> E -> C -> F
 */
public class App_NESTED_demo {
    public static void main(String[] args) throws IOException, InterruptedException {
        CompletableFuture<Void> taskA, taskB, taskC, taskD, taskE, taskF, taskG, taskH;
        // A执行
        taskA = CompletableFuture.runAsync(()->{
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("任务A");
        });
        Thread.sleep(100);
        // C,B等待A
        taskC = taskA.thenRun(()->{
//            try {
//                Thread.sleep(5000);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
            System.out.println("任务C");
        });
        Thread.sleep(100);
        taskB = taskA.thenRun(()->{
//            try {
//                Thread.sleep(5000);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
            System.out.println("任务B");
        });
        //E,D等待B
        taskE = taskB.thenRun(()->{
//            try {
//                Thread.sleep(5000);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
            System.out.println("任务E");
        });
        Thread.sleep(100);
        taskD = taskB.thenRun(()->{
//            try {
//                Thread.sleep(5000);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
            System.out.println("任务D");
        });
        //H,G,F等待C
        taskH = taskC.thenRun(()->{
//            try {
//                Thread.sleep(5000);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
            System.out.println("任务H");
        });
        Thread.sleep(100);
        taskG = taskC.thenRun(()->{
//            try {
//                Thread.sleep(5000);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
            System.out.println("任务G");
        });
        Thread.sleep(100);
        taskF = taskC.thenRun(()->{
//            try {
//                Thread.sleep(5000);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
            System.out.println("任务F");
        });
        System.in.read();
    }
}
