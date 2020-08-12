package src.main.java.com.kotov.thread.task2.threads;

public class Thread2 extends Thread {

    @Override
    public void run() {
        try {
            while (!isInterrupted()) {
                System.out.println("thread #2");
            }
            throw new InterruptedException();
        } catch (InterruptedException e) {
            System.out.println("InterruptedException");
        }
    }
}
