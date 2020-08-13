package src.main.java.com.kotov.thread.decorator;

public class SimpleServices implements AutoService {
    @Override
    public double getPrice() {
        return 100;
    }

    @Override
    public String getServices() {
        return "car painting";
    }
}
