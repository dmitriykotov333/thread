package src.main.java.com.kotov.thread.task9;

public class OurPresident {
    private static OurPresident president;

    static {
        synchronized (OurPresident.class) {
            if (president == null) {
                president = new OurPresident();
            }
        }
    }
    private OurPresident() {
    }

    public static OurPresident getOurPresident() {
        return president;
    }
}
