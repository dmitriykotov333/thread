package src.main.java.com.kotov.thread.task8;

import java.util.ArrayList;
import java.util.List;

/**
 * 1. Создать метод public void addFruit(int index, String fruit) - который добавляет параметр fruit в лист fruits на позицию index.
 * 2. Создать метод public void removeFruit(int index) - который удаляет из fruits элемент с индексом index.
 * 3. Создать метод public void addVegetable(int index, String vegetable) - который добавляет параметр vegetable в лист vegetables на позицию index.
 * 4. Создать метод public void removeVegetable(int index) - который удаляет из vegetables элемент с индексом index.
 * 5. Класс Garden будет использоваться нитями. Поэтому сделай так, чтобы все методы блокировали мьютекс this.
 * 6. Реализуй это минимальным количеством кода.
 */
public class Solution {


    public static void main(String[] args) {

    }

    public static class Garden {

        public final List<String> fruits = new ArrayList<String>();
        public final List<String> vegetables = new ArrayList<String>();

        public synchronized void addFruit(int index, String fruit) {
            fruits.add(index, fruit);
        }

        public synchronized void removeFruit(int index) {
            fruits.remove(index);
        }

        public synchronized  void addVegetable(int index, String vegetable) {
            vegetables.add(index, vegetable);
        }
        public synchronized void removeVegetable(int index) {
            vegetables.remove(index);
        }
    }
}
