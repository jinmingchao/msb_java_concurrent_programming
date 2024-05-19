package thread;

public class T1 implements Runnable{

    @Override
    public void run() {
        System.out.println("T1 start");
        synchronized (this) {
            try {
                Main.lock.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("T1 wake up");
        System.out.println("T1 end");
    }
}
