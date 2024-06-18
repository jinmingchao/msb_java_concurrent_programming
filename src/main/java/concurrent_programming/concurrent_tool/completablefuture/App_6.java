package concurrent_programming.concurrent_tool.completablefuture;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;

/**
 *
 *    子任务(B,C,D,E)调用thenRun(Runnable r)时，会将自己存入主任务(A)的stack中，等待主任务执行完毕，才会依次弹栈执行
 *    本例中，入栈顺序是 B -> C -> D -> E
 *    执行顺序 A -> E -> D -> C -> B
 *
 */
public class App_6 {
    public static void main(String[] args) throws IOException {
        CompletableFuture<Void> taskA= CompletableFuture.runAsync(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("任务A");
        });

        CompletableFuture<Void> taskB = taskA.thenRun(()->{
            System.out.println("任务B");
        });
        CompletableFuture<Void> taskC = taskA.thenRun(()->{
            System.out.println("任务C");
        });
        CompletableFuture<Void> taskD = taskA.thenRun(()->{
            System.out.println("任务D");
        });
        CompletableFuture<Void> taskE = taskA.thenRun(()->{
            System.out.println("任务E");
        });

        System.in.read();
    }
}
