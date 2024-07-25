package thread.date0719.Volatile;

public class App {

    //public static boolean stop = false;

    //todo:volatile 让t1线程感受到了stop变量的变化
    public  volatile static boolean stop = false;

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                int i = 0;
                while (!stop) {
                    i++;
                }
                System.out.println(i);
            }
        });
        t1.start();
        Thread.sleep(5000);
        stop = true;
        System.out.println("主线程结束");
    }
}
