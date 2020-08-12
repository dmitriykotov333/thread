package src.main.java.com.kotov.thread.task2.threads;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Thread5 extends Thread {

    private BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private int sum = 0;

    @Override
    public void run() {
        try {
            String value;
            while (!isInterrupted()) {
                value = bufferedReader.readLine();
                if (value.equals("N")) {
                    interrupt();
                } else {
                    int integer = Integer.parseInt(value);

                    sum += integer;
                }
            }
            throw new InterruptedException();


        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            System.out.println(sum);
        }

    }

}
