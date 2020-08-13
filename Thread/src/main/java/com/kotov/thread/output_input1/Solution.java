package src.main.java.com.kotov.thread.output_input1;

import java.io.*;

/**
 * Ввести с консоли имя файла.
 * Найти максимальный байт в файле, вывести его на экран.
 * Закрыть поток ввода-вывода.
 */
public class Solution {
    public static void main(String[] args) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        try (FileInputStream fileInputStream = new FileInputStream(bufferedReader.readLine())) {
            int max = fileInputStream.read();
            while (fileInputStream.available() > 0) {
                int data = fileInputStream.read();
                if (data > max) {
                    max = data;
                }
            }
            System.out.println(max);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
