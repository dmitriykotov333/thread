package src.main.java.com.kotov.thread.decorator;

/**
 * Decorator
 * Допустим у нас есть какой то обьект, который выполняет какие то функции, и нам нужно расширить его функциональность без определения под классов
 */
public class Solution {
    public static void main(String[] args) {
        AutoService autoService = new SimpleServices();
        System.out.printf("Auto Services\nprice: %f\nservice: %s", autoService.getPrice(), autoService.getServices());
        System.out.println();
        AutoService autoService1 = new ServicesEngine(new SimpleServices());
        System.out.printf("Auto Services\nprice: %f\nservice: %s", autoService1.getPrice(), autoService1.getServices());
    }
}
