package src.main.java.com.kotov.thread.random_access_file1;

import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.io.StringWriter;

/**
 * В метод main приходят три параметра:
 * 1) fileName - путь к файлу;
 * 2) number - число, позиция в файле;
 * 3) text - текст.
 * <p>
 * Считать текст с файла начиная с позиции number, длиной такой же как и длина переданного текста в третьем параметре.
 * Если считанный текст такой же как и text, то записать в конец файла строку 'true', иначе записать 'false'.
 * Используй RandomAccessFile и его методы seek(long pos), read(byte[] b, int off, int len), write(byte[] b).
 * Используй один из конструкторов класса String для конвертации считанной строчки в текст.
 */
public class Solution {
    public static void main(String... args) {

        String text = args[2];
        boolean hasText = false;

        try (RandomAccessFile randomAccessFile = new RandomAccessFile(args[0], "rw")) {
            if ((Long.parseLong(args[1]) + text.length()) < randomAccessFile.length()) {
                byte[] buffer = new byte[text.length() + 2];
                randomAccessFile.seek(Long.parseLong(args[1]));
                randomAccessFile.read(buffer, 0, text.length());
                String textInFile = new String(buffer).trim();

                if (textInFile.equals(text)) {
                    hasText = true;
                }

                System.out.println(textInFile + hasText);

            }
            randomAccessFile.seek(randomAccessFile.length());
            randomAccessFile.write(String.valueOf(hasText).getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}