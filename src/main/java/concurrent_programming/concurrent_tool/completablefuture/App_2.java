package concurrent_programming.concurrent_tool.completablefuture;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;

public class App_2 {
    public static void main(String[] args) throws IOException {
        // 当前方式既不会接收参数，也不会返回任何结果，非常基础的任务编排方式
        CompletableFuture.runAsync(() -> {
            System.out.println("任务go");
            System.out.println("任务done");
        });


        System.in.read();
    }
}
