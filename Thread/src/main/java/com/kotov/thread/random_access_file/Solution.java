package src.main.java.com.kotov.thread.random_access_file;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * В метод main приходят три параметра:
 * 1) fileName - путь к файлу;
 * 2) number - число, позиция в файле;
 * 3) text - текст.
 * Записать text в файл fileName начиная с позиции number.
 * Запись должна производиться поверх старых данных, содержащихся в файле.
 * Если файл слишком короткий, то записать в конец файла.
 */
public class Solution {
    public static void main(String[] args) {
        try (RandomAccessFile raf = new RandomAccessFile(args[0], "rw")) {
            raf.seek(Long.parseLong(args[1]) > raf.length() ? raf.length() : Long.parseLong(args[1]));
            raf.write(args[2].getBytes());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
