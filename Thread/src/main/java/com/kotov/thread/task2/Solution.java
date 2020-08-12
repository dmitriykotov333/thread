package src.main.java.com.kotov.thread.task2;


import src.main.java.com.kotov.thread.task2.threads.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Клубок
 * 1. Создать 5 различных своих нитей c отличным от Thread типом:
 * 1.1. Нить 1 должна бесконечно выполняться;
 * 1.2. Нить 2 должна выводить "InterruptedException" при возникновении исключения InterruptedException;
 * 1.3. Нить 3 должна каждые полсекунды выводить "Ура";
 * 1.4. Нить 4 должна реализовать интерфейс Message, при вызове метода showWarning нить должна останавливаться;
 * 1.5. Нить 5 должна читать с консоли числа пока не введено слово "N", а потом вывести в консоль сумму введенных чисел.
 * 2. В статическом блоке добавить свои нити в List<Thread> threads в перечисленном порядке.
 * 3. Нити не должны стартовать автоматически.
 */
public class Solution {
    public static List<Thread> threads = new ArrayList<>(5);

    static {
        Thread1 thread1 = new Thread1();
        Thread2 thread2 = new Thread2();
        Thread3 thread3 = new Thread3();
        Thread4 thread4 = new Thread4();
        Thread5 thread5 = new Thread5();
        threads.add(thread1);
        threads.add(thread2);
        threads.add(thread3);
        threads.add(thread4);
        threads.add(thread5);
    }
    public static void main(String[] args) {
        threads.get(0).start();


    }



}