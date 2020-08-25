package src.main.java.com.kotov.thread.output_input34;


import java.io.*;
        import java.util.ArrayList;
        import java.util.List;

/**
 * 1. Считать с консоли имя файла. Считать содержимое файла.
 * 2. Для каждой строки в файле:
 * 2.1. переставить все символы в обратном порядке.
 * 2.2. вывести на экран.
 * 3. Закрыть потоки.
 *
 * Пример тела входного файла:
 * я - программист.
 * Амиго
 *
 * Пример результата:
 * .тсиммаргорп - я
 * огимА
 */


        import java.io.BufferedReader;
        import java.io.FileReader;
        import java.io.IOException;
        import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(reader.readLine()));
            while (bufferedReader.ready())
            {
                String s = bufferedReader.readLine();
                StringBuilder gg = new StringBuilder(s);
                gg.reverse();
                System.out.println(gg.toString());
            }

            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}