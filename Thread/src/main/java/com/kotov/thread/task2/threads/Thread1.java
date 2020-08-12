package src.main.java.com.kotov.thread.task2.threads;

public class Thread1 extends Thread {

    @Override
    public void run() {
        while (!interrupted()) {
            System.out.println("thread #1");
        }
    }
}
