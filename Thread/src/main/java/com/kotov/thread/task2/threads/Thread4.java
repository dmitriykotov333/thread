package src.main.java.com.kotov.thread.task2.threads;

import src.main.java.com.kotov.thread.task2.Message;

public class Thread4 extends Thread implements Message {

    @Override
    public void run() {
        while (!interrupted()) {
            System.out.println("thread #4");
        }
    }

    @Override
    public void showWarning() {
        interrupt();
        try {
            join();
        } catch (Exception ignored) {

        }
    }
}
