package src.main.java.com.kotov.thread.task4;

/**
 * Рекурсивное создание нитей
 * 1. Изменить класс GenerateThread так, чтобы он стал нитью.
 * 2. Создать конструктор GenerateThread, который должен:
 * 2.1. Вызвать конструктор суперкласса с параметром String - номером созданной нити. Используй createdThreadCount.
 * 2.2. Запустить текущую нить.
 * 2.3. Номер первой нити должен начинается с 1.
 * 3. Переопределить метод toString
 * 3.1. Метод toString должен возвращать № текущей нити и слово " created".
 * 4. Пока количество созданных нитей меньше Solution.count метод run должен:
 * 4.1. Создать новую нить типа GenerateThread.
 * 4.2. Вывести в консоль созданную в пункте 4.1 нить.
 * 5. В итоге должно быть выведено в консоль 15 строк.
 **/


public class Solution {
    static int count = 15;
    static volatile int createdThreadCount;

    public static void main(String[] args) {
        System.out.println(new GenerateThread());
    }

    public static class GenerateThread extends Thread {

        public GenerateThread() {
            super(String.valueOf(++createdThreadCount));
            start();
        }

        @Override
        public void run() {
            if (createdThreadCount < count) {
                System.out.println(new GenerateThread());
            }


        }

        @Override
        public String toString() {
            return this.getName() + " created";
        }
    }
}
