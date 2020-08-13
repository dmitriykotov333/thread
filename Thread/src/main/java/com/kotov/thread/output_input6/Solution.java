package src.main.java.com.kotov.thread.output_input6;

import java.io.*;

/**
 * Считать с консоли 2 имени файла: файл1, файл2.
 * Записать в файл2 все байты из файл1, но в обратном порядке.
 * Закрыть потоки.
 */
public class Solution {
    public static void main(String[] args) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        try (FileInputStream fileInputStream = new FileInputStream(bufferedReader.readLine())) {
            FileOutputStream fileOutputStream = new FileOutputStream(bufferedReader.readLine());

            byte[] bytes = new byte[fileInputStream.available()];
            if (fileInputStream.available() > 0) {
                fileInputStream.read(bytes);
            }
            byte[] buffer2 = new byte[bytes.length];
            for (int i = 0; i < bytes.length; i++) {
                buffer2[i] = bytes[bytes.length - 1 - i];
            }

            fileOutputStream.write(buffer2);
            fileOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}