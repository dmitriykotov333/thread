package src.main.java.com.kotov.thread.output_input30;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Считать с консоли имя файла.
 * Файл содержит слова, разделенные знаками препинания.
 * Вывести в консоль количество слов "world", которые встречаются в файле.
 * Закрыть потоки.
 */
public class Solution {
    public static void main(String[] args) {

        try(BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            BufferedReader bufferedReader1 = new BufferedReader(new FileReader(bufferedReader.readLine()));
            List<String> lines = new ArrayList<>();
            bufferedReader1.lines().forEach(lines::add);
            int count = 0;
            for (String s : lines) {
                if (s.contains("world")) {
                    count++;
                }
            }
            bufferedReader1.close();
            System.out.println(count);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
