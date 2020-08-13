package src.main.java.com.kotov.thread.decorator;

public abstract class AutoServiceDecorator implements AutoService {

    private AutoService autoService;

    public AutoServiceDecorator(AutoService autoService) {
        this.autoService = autoService;
    }

    @Override
    public double getPrice() {
        return autoService.getPrice();
    }

    @Override
    public String getServices() {
        return autoService.getServices();
    }
}
