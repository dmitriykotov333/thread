package src.main.java.com.kotov.thread.task13;


/*
ApplicationContext
*/

import java.util.HashMap;
import java.util.Map;

/**
 * ApplicationContext будет доступен множеству нитей.
 * Сделать так, чтобы данные не терялись
 * @param <GenericsBean>
 */
abstract class ApplicationContext<GenericsBean extends ApplicationContext.Bean> {
    private Map<String, GenericsBean> container = new HashMap<>();



    protected ApplicationContext() {
        parseAllClassesAndInterfaces();
    }

    /**
     * Надо добавить ключевое слово synchronized чтобы данные не терялись
     * @param name
     * @return
     */
    public synchronized GenericsBean getByName(String name) {
        return container.get(name);
    }

    public synchronized GenericsBean removeByName(String name) {
        return container.remove(name);
    }

    protected abstract void parseAllClassesAndInterfaces();

    public static void main(String[] args) {

    }
    public interface Bean {   // это интерфейс-маркер
    }

}
