package thread.date0714.Sync.demo1;

public class App_6 {
    public static void main(String[] args) {
        for (int i = 0; i < 200; i++) {

            new Thread(()->{
                Object o = new Object();
                synchronized (o){
                    System.out.println(Thread.currentThread().getName()+" is in sync.");
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            },"t-" + i).start();
        }
    }


    class Myr implements Runnable{

        @Override
        public void run() {
            Object o = new Object();
            synchronized (o){
                System.out.println(Thread.currentThread().getName()+" is in sync.");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}


