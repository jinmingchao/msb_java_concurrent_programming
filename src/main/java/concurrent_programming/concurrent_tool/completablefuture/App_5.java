package concurrent_programming.concurrent_tool.completablefuture;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;

public class App_5 {

    public static void main(String[] args) throws IOException {

            CompletableFuture<Integer> taskC = CompletableFuture.supplyAsync(() -> {
                System.out.println("任务A");
                return 78;
            }).applyToEither(CompletableFuture.supplyAsync(() -> {
                System.out.println("任务B");
                return 66;
            }), resultFirst -> {
                System.out.println("任务C");
                return resultFirst;
            });

            System.out.println(taskC.join());
            System.in.read();
        }


}
