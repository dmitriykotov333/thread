package src.main.java.com.kotov.thread.output_input32;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Считать с консоли 2 имени файла.
 * Первый Файл содержит текст.
 * Считать содержимое первого файла и заменить все точки "." на знак "!".
 * Результат вывести во второй файл.
 * Закрыть потоки.
 */
public class Solution {
    public static void main(String[] args) {
        try(BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            List<String> list = new ArrayList<>();
            BufferedReader fileReader = new BufferedReader(new FileReader(bufferedReader.readLine()));
            fileReader.lines().forEach(list::add);
            fileReader.close();
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(bufferedReader.readLine()));
            for (String s : list) {
                bufferedWriter.write(s.replace(".", "!"));
            }
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
