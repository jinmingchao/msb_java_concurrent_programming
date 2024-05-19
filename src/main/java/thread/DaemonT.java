package thread;

public class DaemonT implements Runnable {

    @Override
    public void run() {
        while(true) {
            System.out.println("Daemon thread is running.");
        }
    }
}
