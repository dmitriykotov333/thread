package src.main.java.com.kotov.thread.output_input18;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Считать с консоли 2 имени файла.
 * Первый файл содержит вещественные(дробные) числа, разделенные пробелом. Например, 3.1415.
 * Округлить числа до целых и записать через пробел во второй файл.
 * Закрыть потоки.
 * Принцип округления:
 * 3.49 => 3
 * 3.50 => 4
 * 3.51 => 4
 * -3.49 => -3
 * -3.50 => -3
 * -3.51 => -4
 */
public class Solution {
    public static void main(String[] args) {

        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(bufferedReader.readLine()));
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(bufferedReader.readLine()));
            byte[] bytes = new byte[bufferedInputStream.available()];
            bufferedInputStream.read(bytes);

            bufferedInputStream.close();
            String[] array = new String(bytes).split(" ");
            StringBuilder rst = new StringBuilder(bytes.length);

            for (String strDouble : array) {
                rst.append(Math.round(Double.valueOf(strDouble)));
                rst.append(" ");
            }
            bufferedOutputStream.write(rst.toString().getBytes());
            bufferedOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
