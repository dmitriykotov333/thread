package src.main.java.com.kotov.thread.decorator;

public class ServicesEngine extends AutoServiceDecorator {
    public ServicesEngine(AutoService autoService) {
        super(autoService);
    }

    @Override
    public double getPrice() {
        return super.getPrice() + 340;
    }

    @Override
    public String getServices() {
        return super.getServices() + " + | Engine |";
    }
}
