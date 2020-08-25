package src.main.java.com.kotov.thread.output_input29;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Считать с консоли 2 имени файла.
 * Вывести во второй файл все символы с четным порядковым номером (нумерация начинается с 1).
 *
 * Пример первого файла:
 * text in file
 * Вывод во втором файле:
 * eti ie
 * Закрыть потоки ввода-вывод
 */
public class Solution {
    public static void main(String[] args) {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            FileReader  fileReader = new FileReader (bufferedReader.readLine());
            FileWriter fileWriter = new FileWriter(bufferedReader.readLine());
            int count;
            for (int i = 1; fileReader.ready(); i++) {
                count = fileReader.read();
                if(i % 2 == 0) {
                    fileWriter.write(count);
                }
            }
            fileReader.close();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
