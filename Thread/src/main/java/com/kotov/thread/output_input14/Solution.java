package src.main.java.com.kotov.thread.output_input14;

import java.io.*;

/**
 * В метод main первым параметром приходит имя файла.
 * Посчитать количество букв английского алфавита, которое есть в этом файле.
 * Вывести на экран число (количество букв).
 * Закрыть потоки.
 */
public class Solution {
    public static void main(String[] args) {
        int count = 0;
        try (BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(args[0]))) {
            while (bufferedInputStream.available() > 0) {
                int data = bufferedInputStream.read();
                if ((data >= (int) 'A' && data <= (int) 'Z')
                        || (data >= (int) 'a' && data <= (int) 'z')) {
                    count++;
                }
            }
            System.out.println(count);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
