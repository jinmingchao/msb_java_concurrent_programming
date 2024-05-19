package thread.date0710.responsibleChain;

import java.util.concurrent.LinkedBlockingQueue;

public class SaveProcessor implements IRequestProcessor, Runnable{
    LinkedBlockingQueue<Request> requests = new LinkedBlockingQueue();

    private final IRequestProcessor nextProcessor;

    private volatile boolean isFinished = false;

    public SaveProcessor(IRequestProcessor nextProcessor) {
        this.nextProcessor = nextProcessor;
    }


    @Override
    public void process(Request request) {
        //TODO
        //验证请求参数
        requests.add(request); //放入队列等待当前processor处理
    }

    @Override
    public void run() { //建议使用线程池
        while (!isFinished) {
            try {
                Request request = requests.take(); //阻塞取
                // 真正Prev的处理逻辑在这里
                System.out.println("Do SaveProcessor: " + request);
                // 将request交给下一个processor
                if(null != nextProcessor) {
                    nextProcessor.process(request);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    public boolean shutDown() {
        return isFinished = true;
    }
}
