package src.main.java.com.kotov.thread.output_input5;

import java.io.*;

/**
 * Считать с консоли три имени файла: файл1, файл2, файл3.
 * Разделить файл1 по следующему критерию:
 * Первую половину байт записать в файл2, вторую половину байт записать в файл3.
 * Если в файл1 количество байт нечетное, то файл2 должен содержать большую часть.
 * Закрыть потоки.
 */
public class Solution {

    public static void main(String[] args) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int lengthSecondFile;
        try (FileInputStream fileInputStream = new FileInputStream(bufferedReader.readLine())) {
            FileOutputStream fileOutputStream1 = new FileOutputStream(bufferedReader.readLine());
            FileOutputStream fileOutputStream2 = new FileOutputStream(bufferedReader.readLine());
            while (fileInputStream.available() > 0) {
                if (fileInputStream.available() % 2 == 0) {
                    lengthSecondFile = fileInputStream.available() / 2;
                } else {
                    lengthSecondFile = fileInputStream.available() / 2 + 1;
                }
                byte[] bufferForSecondFile = new byte[lengthSecondFile];
                byte[] bufferForThreadFile = new byte[fileInputStream.available() / 2];
                    fileOutputStream1.write(bufferForSecondFile, 0, fileInputStream.read(bufferForSecondFile));
                    fileOutputStream2.write(bufferForThreadFile, 0, fileInputStream.read(bufferForThreadFile));
            }
            fileOutputStream1.close();
            fileOutputStream2.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
