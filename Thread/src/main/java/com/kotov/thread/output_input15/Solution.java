package src.main.java.com.kotov.thread.output_input15;


import java.io.*;

/**
 * В метод main первым параметром приходит имя файла.
 * Вывести на экран соотношение количества пробелов к количеству всех символов. Например, 10.45.
 * 1. Посчитать количество всех символов.
 * 2. Посчитать количество пробелов.
 * 3. Вывести на экран п2/п1*100, округлив до 2 знаков после запятой.
 * 4. Закрыть потоки.
 */
public class Solution {
    public static void main(String[] args) {
        int count = 0;
        int spaces = 0;
        double res = 0;
        if (args.length > 0) {
            try (BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(args[0]))) {
                while (bufferedInputStream.available() > 0) {
                    count++;
                    int data = bufferedInputStream.read();
                    if (data == ' ') {
                        spaces++;
                    }
                }
                res = (double) spaces / count * 100;
                System.out.printf("%.2f", res);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
