package src.main.java.com.kotov.thread.output_input16;

import java.io.*;

/**
 * Считать с консоли 3 имени файла.
 * Записать в первый файл содержимого второго файла, а потом дописать в первый файл содержимое третьего файла.
 * Закрыть потоки.
 */
public class Solution {
    public static void main(String[] args) {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            BufferedOutputStream bufferedInputStream1 = new BufferedOutputStream(new FileOutputStream(bufferedReader.readLine(), true));
            BufferedInputStream bufferedInputStream2 = new BufferedInputStream(new FileInputStream(bufferedReader.readLine()));
            BufferedInputStream bufferedInputStream3 = new BufferedInputStream(new FileInputStream(bufferedReader.readLine()));

            byte[] bytes2 = new byte[bufferedInputStream2.available()];
            bufferedInputStream2.read(bytes2);
            byte[] bytes3 = new byte[bufferedInputStream3.available()];
            bufferedInputStream3.read(bytes3);

            bufferedInputStream1.write(bytes2);
            bufferedInputStream1.write(bytes3);

            bufferedInputStream1.close();
            bufferedInputStream2.close();
            bufferedInputStream3.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
