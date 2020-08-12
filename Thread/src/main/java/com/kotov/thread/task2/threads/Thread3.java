package src.main.java.com.kotov.thread.task2.threads;

public class Thread3 extends Thread {

    @Override
    public void run() {
        while (!interrupted()) {
            try {
                System.out.println("Ура");
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println("exception");
            }
        }
    }
}
