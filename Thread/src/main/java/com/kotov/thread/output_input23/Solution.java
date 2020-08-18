package src.main.java.com.kotov.thread.output_input23;

import java.io.*;
import java.util.*;

/**
 * Собираем файл из кусочков.
 * Считывать с консоли имена файлов.
 * Каждый файл имеет имя: [someName].partN.
 * <p>
 * Например, Lion.avi.part1, Lion.avi.part2, ..., Lion.avi.part37.
 * <p>
 * Имена файлов подаются в произвольном порядке. Ввод заканчивается словом "end".
 * В папке, где находятся все прочтенные файлы, создать файл без суффикса [.partN].
 * <p>
 * Например, Lion.avi.
 * <p>
 * В него переписать все байты из файлов-частей используя буфер.
 * Файлы переписывать в строгой последовательности, сначала первую часть, потом вторую, ..., в конце - последнюю.
 * Закрыть потоки.
 */
public class Solution {
    public static void main(String[] args) {
        String value;
        Set<String> set = new TreeSet<>();
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            while (!(value = bufferedReader.readLine()).equals("end")) {
                set.add(value);
            }
            Iterator<String> iterator = set.iterator();
            BufferedOutputStream bufferedOutputStream = null;
            while (iterator.hasNext()) {
                String folder = iterator.next();
                folder = folder.substring(0, folder.lastIndexOf('.'));
                bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(folder, true));


                BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(folder));
                byte[] bytes = new byte[bufferedInputStream.available()];
                while (bufferedInputStream.available() > 0) {
                    int readed = bufferedInputStream.read(bytes);
                    bufferedOutputStream.write(bytes, 0, readed);
                }
                bufferedInputStream.close();
            }
            bufferedOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
