package thread.date20231108.shutdownthread;

import java.util.concurrent.*;

public class App2 {

    public static void main(String[] args) throws InterruptedException {

        ExecutorService es = new ThreadPoolExecutor(1,1,10L,TimeUnit.SECONDS,new LinkedBlockingQueue<>(10));
        Future<Integer> r = es.submit(new task());
        Thread.sleep(3000);
        es.shutdown();
        System.out.println("Main thread calls shutDown().");

        if (!es.awaitTermination(10, TimeUnit.SECONDS)) {//10S
            System.out.println("Main thread calls shutDownNow().");
            es.shutdownNow();
        }

        while (!r.isDone()) {

        }
        r.isDone();
//        r.isCancelled();
        System.out.println("r: " + r);
        try {
            System.out.println("r.val: " + r.get());
        } catch (ExecutionException e) {
            e.printStackTrace();
        }


    }



}

class task implements Callable {

    BlockingQueue<String> q = new LinkedBlockingQueue<>();

    @Override
    public Integer call() throws Exception {
        try {
            System.out.println("task call take().");
            q.take();

        } catch (InterruptedException var0){
            var0.printStackTrace();
            System.out.println("task was interrupted.");
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("task finished.");
        return 111;
    }
}
