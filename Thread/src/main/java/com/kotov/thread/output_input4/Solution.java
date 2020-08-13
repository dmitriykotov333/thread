package src.main.java.com.kotov.thread.output_input4;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * С консоли считать имя файла.
 * Посчитать в файле количество символов ',', количество вывести на консоль.
 * Закрыть потоки.
 */
public class Solution {
    public static void main(String[] args) {
        int count = 0;
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        try (FileInputStream fileInputStream = new FileInputStream(bufferedReader.readLine())) {
            while (fileInputStream.available() > 0) {
                if (fileInputStream.read() == 44) {
                    count++;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println(count);
        }

    }
}
