package thread.date0714.Sync.demo1;

public class App_7 {
    public static void main(String[] args) throws InterruptedException {
        Object o1 = new Object();
        Object o2 = new Object();
        synchronized (o1) {
            o2.wait(); //wait方法必须在获取锁的时候调用
        }
    }
}
