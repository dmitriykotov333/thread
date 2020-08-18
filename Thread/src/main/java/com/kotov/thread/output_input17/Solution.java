package src.main.java.com.kotov.thread.output_input17;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Считать с консоли 2 имени файла.
 * В начало первого файла записать содержимое второго файла так, чтобы получилось объединение файлов.
 * Закрыть потоки.
 */
public class Solution {
    public static void main(String[] args) {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            BufferedInputStream fis2 = new BufferedInputStream(new FileInputStream(bufferedReader.readLine()));
            BufferedInputStream fis1 = new BufferedInputStream(new FileInputStream(bufferedReader.readLine()));
            List<Integer> list = new ArrayList<>();
            while (fis2.available() > 0) {
                list.add(fis2.read());
            }
            while (fis1.available() > 0) {
                list.add(fis1.read());
            }

            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(bufferedReader.readLine()));

            for (int x : list) {
                bufferedOutputStream.write(x);
            }

            fis1.close();
            fis2.close();
            bufferedOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}