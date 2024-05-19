package thread.date0710.responsibleChain;

public class App {

    IRequestProcessor requestProcessor;

    public App(){
        //prevProcessor -> saveProcessor -> printProcessor

        PrintProcessor printProcessor = new PrintProcessor();
        new Thread(printProcessor).start();
        SaveProcessor saveProcessor = new SaveProcessor(printProcessor);
        new Thread(saveProcessor).start();
        requestProcessor = new PrevProcessor(saveProcessor);
        new Thread((Runnable) requestProcessor).start();

    }

    public static void main(String[] args) {
        Request request = new Request(); //将要被处理的对象
        request.setName("jmc");
        new App().requestProcessor.process(request);
    }
}
