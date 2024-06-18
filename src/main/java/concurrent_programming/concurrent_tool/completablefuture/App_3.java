package concurrent_programming.concurrent_tool.completablefuture;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 *
 * 有任务A，还有任务B。
 *
 * 任务B需要在任务A执行完毕后再执行。
 *
 * 而且任务B需要任务A的返回结果。
 *
 * 任务B自身也有返回结果。
 *
 * thenApply可以拼接异步任务，前置任务处理完之后，将返回结果交给后置任务，然后后置任务再执行
 *
 * thenApply提供了带有Async的方法，可以指定每个任务使用的具体线程池。
 */
public class App_3 {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(10);

    CompletableFuture<String> taskA = CompletableFuture.supplyAsync(() -> {
        String id = UUID.randomUUID().toString();
        System.out.println("执行任务A：" + id);
        return id;
    });


    CompletableFuture<String> taskB = taskA.thenApply(result -> {
        System.out.println("任务B获取到任务A结果：" + result);
        result = result.replace("-", "");
        return result;
    });

    System.out.println("main线程拿到结果：" + taskB.join());

//        CompletableFuture<String> taskB = CompletableFuture.supplyAsync(() -> {
//            String id = UUID.randomUUID().toString();
//            System.out.println("执行任务A：" + id + "," + Thread.currentThread().getName());
//            return id;
//        }).thenApplyAsync(result -> {
//            System.out.println("任务B获取到任务A结果：" + result + "," + Thread.currentThread().getName());
//            result = result.replace("-", "");
//            return result;
//        },executor);
//
//        System.out.println("main线程拿到结果：" + taskB.join());
    }

}
